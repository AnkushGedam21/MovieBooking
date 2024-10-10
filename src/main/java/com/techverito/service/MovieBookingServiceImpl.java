package com.techverito.service;


import com.techverito.enums.SeatType;
import com.techverito.model.*;
import com.techverito.repository.MovieBookingRepo;
import com.techverito.utils.CostTaxUtils;
import com.techverito.utils.UserInputUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class MovieBookingServiceImpl implements MovieBookingService{
    private final MovieBookingRepo movieBookingRepo;
    private final UserInputUtil userInputUtil;
    private final TotalRevenueService totalRevenueService;

    public MovieBookingServiceImpl(MovieBookingRepo movieBookingRepo, UserInputUtil userInputUtil, TotalRevenueService totalRevenueService) {
        this.movieBookingRepo = movieBookingRepo;
        this.userInputUtil = userInputUtil;
        this.totalRevenueService = totalRevenueService;
    }

    @Override
    public void bookShowTickets() {
        try {
            System.out.print("Enter Show Number::");
            String showNum = userInputUtil.getUserInput();
            if ("1".equals(showNum) || "2".equals(showNum) || "3".equals(showNum)) {
                long showId = Long.parseLong(showNum);
                ShowSeats showSeats = movieBookingRepo.getShowSeats(showId);
                displayAvailableTickets(showSeats);
                List<String> seatsNo = userInputUtil.getSeatsInputFromUser();
                if (isSeatAvailable(showSeats, seatsNo)) {
                    SeatCostSubTotal seatCostSubTotal = getTotalCost(showSeats, seatsNo);
                    movieBookingRepo.updateShowSeats(showId, seatsNo);
                      totalRevenueService.updatesTotalRevenue(seatCostSubTotal);
                        displaySucessfulTicketBooksAndCost(seatCostSubTotal, showSeats.getShowName());
                }

            } else {
                System.out.println("Invalid Show Number");
            }
            System.out.print("Would you like to continue(Yes/No):");
            String userInput = userInputUtil.getUserInput();
            if ("yes".equalsIgnoreCase(userInput) || "Y".equalsIgnoreCase(userInput)) {
                bookShowTickets();
            } else if ("NO".equalsIgnoreCase(userInput) || "N".equalsIgnoreCase(userInput)) {
                totalRevenueService.displayTotalRevenue();
                return;
            } else {
                System.out.println("Invalid Input: Try Again.");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong, Please try again...");
        }

        //bookShowTickets();
    }

    private void displaySucessfulTicketBooksAndCost(SeatCostSubTotal seatCostSubTotal, String showName) {
        System.out.println("Successfully Booked - " + showName);
        System.out.println("Subtotal: Rs. " + seatCostSubTotal.getTotalCost());
        System.out.println("Service tax @14%: Rs. " + seatCostSubTotal.getTotalServiceTax());
        System.out.println("Swachh Bharat Cess @0.5%: Rs. " + seatCostSubTotal.getTotalSwachhBharatCess());
        System.out.println("Krishi Kaklyan Cess@0.5%: Rs. " + seatCostSubTotal.getTotalKrishiKalyanCess());
        System.out.println("Total: Rs. " + String.valueOf(getTotalCost(seatCostSubTotal)));
        System.out.println();
    }

    private double getTotalCost(SeatCostSubTotal seatCostSubTotal) {
        return CostTaxUtils.getDecimalFormatValue(seatCostSubTotal.getTotalCost()+ seatCostSubTotal.getTotalServiceTax()+ seatCostSubTotal.getTotalSwachhBharatCess()+ seatCostSubTotal.getTotalKrishiKalyanCess());
    }

    private boolean isSeatAvailable(ShowSeats seats, List<String> seatsNo) {
       List<String> availableSeats = seats.getAllAvailableSeats().stream()
               .filter(seat -> seatsNo.contains(seat))
               .collect(Collectors.toList());
       if(availableSeats.size() == seatsNo.size()){
           return  true;
       }
       else {
           List<String> absentSeats = seatsNo.stream().filter(seat -> !availableSeats.contains(seat))
                    .collect(Collectors.toList());
            System.out.println(absentSeats + " Not available, Please select different seats");
            return false;
       }

    }

    private void displayAvailableTickets(ShowSeats show) throws Exception{
        System.out.println("Available Seats for Show::"+show.getShowName());
        for(Seat seat : show.getSeats()){
            System.out.println(seat.getSeats());
        }
    }
    public SeatCostSubTotal getTotalCost(ShowSeats showSeats, List<String> seatsNo) {
        double totalCost=0.00,
                totalServiceTax=0.00,
                totalSwachhBharatCess=0.00,
                totalKrishiKalyanCess=0.00;
        List<Seat> seats= showSeats.getSeats();
        for(Seat seat : seats) {
            for (String seatNo : seatsNo) {
                for (String seatNoFromSeatObject : seat.getSeats()) {
                    if (seatNoFromSeatObject.equals(seatNo)) {
                        SeatCost seatCost = seat.getPrice();
                        totalCost += seatCost.getCost();
                        totalServiceTax += seatCost.getServiceTax();
                        totalSwachhBharatCess += seatCost.getSwachhBharatCess();
                        totalKrishiKalyanCess += seatCost.getKrishiKalyanCess();
                    }
                }
            }
        }
        return SeatCostSubTotal.builder()
                .totalCost(totalCost)
                .totalServiceTax(totalServiceTax)
                .totalSwachhBharatCess(totalSwachhBharatCess)
                .totalKrishiKalyanCess(totalKrishiKalyanCess)
                .build();

    }
}

package com.techverito.mock;

import com.techverito.enums.SeatType;
import com.techverito.model.Seat;
import com.techverito.model.SeatCost;
import com.techverito.model.SeatCostSubTotal;
import com.techverito.model.ShowSeats;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MockData {
    private static ShowSeats showSeat1;

    public static final double TOTAL_COST=560.0;
    public static final double TOTAL_SERVICE_TAX = 78.4;
    public static final double TOTAL_SWACHHBHARAT_CESS = 2.8;
    public static final double TOTAL_KRISHIKALYAN_CESS = 2.8;

     public static ShowSeats getShowSeatsForFirstShow() {
        if(showSeat1 == null) {
            showSeat1 = new ShowSeats();
            Seat platinumSeat = new Seat();
            platinumSeat.setSeatType(SeatType.PLATINUM);
            platinumSeat.setSeats(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9"));
            platinumSeat.setPrice(getSeatCost(SeatType.PLATINUM));
            Seat goldSeat = new Seat();
            goldSeat.setSeatType(SeatType.GOLD);
            goldSeat.setSeats(Arrays.asList("B1", "B2", "B3", "B4", "B5", "B6"));
            goldSeat.setPrice(getSeatCost(SeatType.GOLD));
            Seat silverSeat = new Seat();
            silverSeat.setSeatType(SeatType.SILVER);
            silverSeat.setSeats(Arrays.asList("C2", "C3", "C4", "C5", "C6", "C7"));
            silverSeat.setPrice(getSeatCost(SeatType.SILVER));
            showSeat1.setShowName("Show 1");
            showSeat1.setSeats(Arrays.asList(platinumSeat, goldSeat, silverSeat));
        }
        return showSeat1;
    }
    public static SeatCost getSeatCost(SeatType seatType) {
        SeatCost seatCost = new SeatCost();
        if(SeatType.PLATINUM.equals(seatType))
            seatCost.setCost(320.00);
        else if(SeatType.GOLD.equals(seatType))
            seatCost.setCost(280.0);
        else{
            seatCost.setCost(240.0);
        }
        seatCost.setServiceTax(seatCost.getCost()*0.14);
        seatCost.setSwachhBharatCess(getTax(seatCost.getCost(),0.5));
        seatCost.setKrishiKalyanCess(getTax(seatCost.getCost(),0.5));
        return seatCost;
    }
    private static double getTax(double cost ,double percentage) throws ArithmeticException{
        return cost * (percentage / 100);
    }

    public static SeatCostSubTotal getSubTotalSeatCost() {
         return SeatCostSubTotal.builder()
                 .totalCost(TOTAL_COST)
                 .totalServiceTax(TOTAL_SERVICE_TAX)
                 .totalSwachhBharatCess(TOTAL_SWACHHBHARAT_CESS)
                 .totalKrishiKalyanCess(TOTAL_KRISHIKALYAN_CESS)
                 .build();
    }
//    public static double getDecimalFormatValue(double value){
//        DecimalFormat df = new DecimalFormat("#.00");
//        String formatedValue= df.format(value);
//        return Double.parseDouble(formatedValue);
//    }
}

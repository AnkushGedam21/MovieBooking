package com.techverito.service;

import com.techverito.model.SeatCostSubTotal;
import com.techverito.model.SeatCostTotalRevenue;
import org.springframework.stereotype.Service;

@Service
public class TotalRevenueService {
    private final SeatCostTotalRevenue seatCostTotalRevenue;

    public TotalRevenueService(SeatCostTotalRevenue seatCostTotalRevenue) {
        this.seatCostTotalRevenue = seatCostTotalRevenue;
    }

    public void updatesTotalRevenue(SeatCostSubTotal seatCostSubTotal) {
        seatCostTotalRevenue.setTotalCost(seatCostTotalRevenue.getTotalCost() + seatCostSubTotal.getTotalCost());
        seatCostTotalRevenue.setTotalServiceTax(seatCostTotalRevenue.getTotalServiceTax() + seatCostSubTotal.getTotalServiceTax());
        seatCostTotalRevenue.setTotalSwachhBharatCess(seatCostTotalRevenue.getTotalSwachhBharatCess() + seatCostSubTotal.getTotalSwachhBharatCess());
        seatCostTotalRevenue.setTotalKrishiKalyanCess(seatCostTotalRevenue.getTotalKrishiKalyanCess() + seatCostSubTotal.getTotalKrishiKalyanCess());
    }

    public SeatCostTotalRevenue getSeatCostTotalRevenue() {
        return seatCostTotalRevenue;
    }

    public void displayTotalRevenue() {
        System.out.println("Total Sales:");
        System.out.println("Revenue: Rs." + (seatCostTotalRevenue.getTotalCost()));
        System.out.println("Service Tax: Rs. " + seatCostTotalRevenue.getTotalServiceTax());
        System.out.println("Swachh Bharat Cess: Rs. " + seatCostTotalRevenue.getTotalSwachhBharatCess());
        System.out.println("Krishi Kalyan Cess: Rs. " + seatCostTotalRevenue.getTotalKrishiKalyanCess());
    }
}

package com.techverito.utils;

import com.techverito.enums.SeatType;
import com.techverito.model.SeatCost;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class CostTaxUtils {
    public static final double SERVICE_TAX = 0.14;
    public static final double SWACHHBHARAT_CESS_TAX = 0.5;
    public static final double KRISHIKALYAN_CESS_TAX = 0.5;

    public static SeatCost getSeatCost(SeatType seatType) {
        SeatCost seatCost = new SeatCost();
        if (SeatType.PLATINUM.equals(seatType))
            seatCost.setCost(320.00);
        else if (SeatType.GOLD.equals(seatType))
            seatCost.setCost(280.0);
        else {
            seatCost.setCost(240.0);
        }
        seatCost.setServiceTax(seatCost.getCost() * SERVICE_TAX);
        seatCost.setSwachhBharatCess(getTax(seatCost.getCost(), SWACHHBHARAT_CESS_TAX));
        seatCost.setKrishiKalyanCess(getTax(seatCost.getCost(), KRISHIKALYAN_CESS_TAX));
        return seatCost;
    }

    private static double getTax(double cost, double percentage) throws ArithmeticException {
        return cost * (percentage / 100);
    }

    public static double getDecimalFormatValue(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        String formatedValue = df.format(value);
        return Double.parseDouble(formatedValue);
    }
}

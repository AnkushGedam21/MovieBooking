package com.techverito.model;

import com.techverito.utils.CostTaxUtils;
import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SeatCostTotalRevenue {
    private double totalCost;
    private double totalServiceTax;
    private double totalSwachhBharatCess;
    private double totalKrishiKalyanCess;

    public double getTotalCost() {
        return CostTaxUtils.getDecimalFormatValue(totalCost);
    }

    public double getTotalServiceTax() {
        return CostTaxUtils.getDecimalFormatValue(totalServiceTax);
    }

    public double getTotalSwachhBharatCess() {
        return CostTaxUtils.getDecimalFormatValue(totalSwachhBharatCess);
    }

    public double getTotalKrishiKalyanCess() {
        return CostTaxUtils.getDecimalFormatValue(totalKrishiKalyanCess);
    }


}

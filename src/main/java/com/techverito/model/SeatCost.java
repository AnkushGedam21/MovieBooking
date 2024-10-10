package com.techverito.model;

import com.techverito.constant.CommonConstant;
import com.techverito.utils.CostTaxUtils;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Builder
public class SeatCost {
    private double cost;
    private double serviceTax;
    private double swachhBharatCess;
    private double krishiKalyanCess;

    public double getCost() {
        return CostTaxUtils.getDecimalFormatValue(cost);
    }

    public double getServiceTax() {
        return CostTaxUtils.getDecimalFormatValue(serviceTax);
    }

    public double getSwachhBharatCess() {
        return CostTaxUtils.getDecimalFormatValue(swachhBharatCess);
    }

    public double getKrishiKalyanCess() {
        return CostTaxUtils.getDecimalFormatValue(krishiKalyanCess);
    }

}

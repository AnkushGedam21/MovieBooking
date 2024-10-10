package com.techverito.service;

import com.techverito.mock.MockData;
import com.techverito.model.SeatCostTotalRevenue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TotalRevenueServiceTest {

    @InjectMocks
    private TotalRevenueService totalRevenueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        SeatCostTotalRevenue seatCostTotalRevenue = new SeatCostTotalRevenue();
        this.totalRevenueService = new TotalRevenueService(seatCostTotalRevenue);
    }

    @Test
    public void testUpdatesTotalRevenue() {
        totalRevenueService.updatesTotalRevenue(MockData.getSubTotalSeatCost());
        totalRevenueService.updatesTotalRevenue(MockData.getSubTotalSeatCost());
        SeatCostTotalRevenue seatCostTotalRevenue1 = totalRevenueService.getSeatCostTotalRevenue();
        assertNotNull(seatCostTotalRevenue1);
        assertEquals((MockData.TOTAL_COST * 2), seatCostTotalRevenue1.getTotalCost());
        assertEquals((MockData.TOTAL_SERVICE_TAX * 2), seatCostTotalRevenue1.getTotalServiceTax());
        assertEquals((MockData.TOTAL_SWACHHBHARAT_CESS * 2), seatCostTotalRevenue1.getTotalSwachhBharatCess());
        assertEquals((MockData.TOTAL_KRISHIKALYAN_CESS * 2), seatCostTotalRevenue1.getTotalKrishiKalyanCess());
    }
}

package com.techverito.dummy;

import com.techverito.enums.SeatType;
import com.techverito.exceptions.DataNotFoundException;
import com.techverito.model.Seat;
import com.techverito.model.SeatCost;
import com.techverito.model.ShowSeats;
import com.techverito.utils.CostTaxUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MockData {
    private ShowSeats showSeat1;
    private ShowSeats showSeat2;
    private ShowSeats showSeat3;
    public ShowSeats getShowSeats(int showId) throws DataNotFoundException{
        switch (showId){
            case 1: return getShowSeatsForFirstShow();
            case 2: return getShowSeatsForSecondShow();
            case 3: return getShowSeatsForThirdShow();
            default:throw new DataNotFoundException("Invalid Show Number");
        }
    }
    public void setShowSeat(ShowSeats showSeat, int showId){
        switch (showId){
            case 1:  setShowSeatsForFirstShow(showSeat);
            case 2:  setShowSeatsForSecondShow(showSeat);
            case 3:  setShowSeatsForThirdShow(showSeat);
        }
    }

    private  ShowSeats getShowSeatsForThirdShow() {
        if(this.showSeat3 == null) {
            this.showSeat3 = new ShowSeats();
            Seat platinumSeat = new Seat();
            platinumSeat.setSeatType(SeatType.PLATINUM);
            platinumSeat.setSeats(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7"));
            platinumSeat.setPrice(getSeatCost(SeatType.PLATINUM));
            Seat goldSeat = new Seat();
            goldSeat.setSeatType(SeatType.GOLD);
            goldSeat.setSeats(Arrays.asList("B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8"));
            goldSeat.setPrice(getSeatCost(SeatType.GOLD));
            Seat silverSeat = new Seat();
            silverSeat.setSeatType(SeatType.SILVER);
            silverSeat.setSeats(Arrays.asList("C1", "C2", "C3", "C4", "C5", "C6", "C8", "C9"));
            silverSeat.setSeatType(SeatType.SILVER);
            this.showSeat3.setShowName("Show 1");
            this.showSeat3.setSeats(Arrays.asList(platinumSeat, goldSeat, silverSeat));
        }
        return showSeat3;
    }

    private SeatCost getSeatCost(SeatType seatType) {
        return CostTaxUtils.getSeatCost(seatType);
    }

    private  ShowSeats getShowSeatsForSecondShow() {
        if(this.showSeat2 == null) {
            this.showSeat2 = new ShowSeats();
            Seat platinumSeat = new Seat();
            platinumSeat.setSeatType(SeatType.PLATINUM);
            platinumSeat.setSeats(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7"));
            platinumSeat.setPrice(getSeatCost(SeatType.PLATINUM));
            Seat goldSeat = new Seat();
            goldSeat.setSeatType(SeatType.GOLD);
            goldSeat.setSeats(Arrays.asList("B2", "B3", "B4", "B5", "B6"));
            goldSeat.setPrice(getSeatCost(SeatType.GOLD));
            Seat silverSeat = new Seat();
            silverSeat.setSeatType(SeatType.SILVER);
            silverSeat.setSeats(Arrays.asList("C1", "C2", "C3", "C4", "C5", "C6", "C7"));
            silverSeat.setSeatType(SeatType.SILVER);
            this.showSeat2.setShowName("Show 2");
            this.showSeat2.setSeats(Arrays.asList(platinumSeat, goldSeat, silverSeat));
        }
        return this.showSeat2;
    }

    private ShowSeats getShowSeatsForFirstShow() {
        if(this.showSeat1 == null) {
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
            this.showSeat1.setShowName("Show 1");
            this.showSeat1.setSeats(Arrays.asList(platinumSeat, goldSeat, silverSeat));
        }
        return this.showSeat1;
    }

    private void setShowSeatsForFirstShow(ShowSeats showSeat1) {
        this.showSeat1 = showSeat1;
    }
    private void setShowSeatsForSecondShow(ShowSeats showSeat2) {
        this.showSeat2 = showSeat2;
    }
    private void setShowSeatsForThirdShow(ShowSeats showSeat1) {
        this.showSeat3 = showSeat3;
    }

}

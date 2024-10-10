package com.techverito.repository;

import com.techverito.dummy.MockData;
import com.techverito.model.Seat;
import com.techverito.model.ShowSeats;
import com.techverito.utils.CostTaxUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieBookingRepo {
    private final MockData mockData;

    public MovieBookingRepo(MockData mockData) {
        this.mockData = mockData;
    }
    public ShowSeats getShowSeats(long showId) {
        return mockData.getShowSeats((int) showId);
    }
    public void updateShowSeats(long showId, List<String> seatsNo) throws UnsupportedOperationException {
        ShowSeats showSeats = mockData.getShowSeats((int) showId);
        List<Seat> updatedSeats = new ArrayList<>();
        for (Seat seat : showSeats.getSeats()) {
            for (String seatNo : seatsNo) {
                List<String> updatedSeatNoList = seat.getSeats().stream()
                        .filter(s -> !s.equals(seatNo))
                        .collect(Collectors.toList());
                seat.setSeats(updatedSeatNoList);
                seat.setSeatType(seat.getSeatType());
                seat.setPrice(CostTaxUtils.getSeatCost(seat.getSeatType()));
            }
            updatedSeats.add(seat);
        }
        mockData.setShowSeat(showSeats, (int) showId);
    }
}

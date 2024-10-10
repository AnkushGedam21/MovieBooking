package com.techverito.model;

import com.techverito.enums.SeatType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Seat {
    private SeatType seatType;
    private List<String> seats;
    private SeatCost price;
}

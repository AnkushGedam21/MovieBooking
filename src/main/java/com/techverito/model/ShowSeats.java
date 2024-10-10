package com.techverito.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public  class ShowSeats {

    private String showName;
    private List<Seat> seats;

    public List<String> getAllAvailableSeats(){
        List<String> allAvailableSeats = new ArrayList<>();
        for(Seat seat : seats){
            allAvailableSeats.addAll(seat.getSeats());
        }
        return allAvailableSeats;
    }
}

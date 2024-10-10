package com.techverito.service;

import com.techverito.mock.MockData;
import com.techverito.repository.MovieBookingRepo;
import com.techverito.utils.UserInputUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieBookingServiceTest {

    @Mock
    private MovieBookingRepo movieBookingRepo;
    @Mock
    private UserInputUtil userInputUtil;
    @Mock
    private TotalRevenueService totalRevenueService;
    @InjectMocks
    private MovieBookingServiceImpl movieBookingService;

    @Test
    public void testBookShowTickets() throws Exception {
        Mockito.when(userInputUtil.getUserInput()).thenReturn("1");
        Mockito.when(movieBookingRepo.getShowSeats(anyLong())).thenReturn(MockData.getShowSeatsForFirstShow());
        Mockito.when(userInputUtil.getSeatsInputFromUser()).thenReturn(Arrays.asList("B1", "B3"));
        Mockito.doNothing().when(movieBookingRepo).updateShowSeats(anyLong(), anyList());
        Mockito.doNothing().when(totalRevenueService).updatesTotalRevenue(any());
        movieBookingService.bookShowTickets();
        verify(userInputUtil, times(2)).getUserInput();
        verify(movieBookingRepo).getShowSeats(anyLong());
        verify(userInputUtil).getSeatsInputFromUser();
        verify(movieBookingRepo).updateShowSeats(anyLong(), anyList());
        verify(totalRevenueService).updatesTotalRevenue(any());
    }
}


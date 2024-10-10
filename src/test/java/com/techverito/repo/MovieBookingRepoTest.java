package com.techverito.repo;

import com.techverito.dummy.MockData;
import com.techverito.model.ShowSeats;
import com.techverito.repository.MovieBookingRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieBookingRepoTest {
    @Mock
    private  MockData mockData;
    @InjectMocks
    private MovieBookingRepo movieBookingRepo;

    @Test
    public void testGetShowSeats(){
        Mockito.when(mockData.getShowSeats(anyInt())).thenReturn(com.techverito.mock.MockData.getShowSeatsForFirstShow());
        ShowSeats showSeats = movieBookingRepo.getShowSeats(1);
        assertNotNull(showSeats);
        assertEquals("Show 1", showSeats.getShowName());
        assertNotNull(showSeats.getSeats());

    }
}

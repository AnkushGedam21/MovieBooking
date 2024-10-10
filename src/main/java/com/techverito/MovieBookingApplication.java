package com.techverito;

import com.techverito.service.MovieBookingService;
import com.techverito.service.MovieBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieBookingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieBookingApplication.class, args);
		MovieBookingService movieBookingService = context.getBean(MovieBookingService.class);
		movieBookingService.bookShowTickets();

	}

}

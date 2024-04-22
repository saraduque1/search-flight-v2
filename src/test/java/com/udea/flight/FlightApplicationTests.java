package com.udea.flight;

import com.udea.flight.service.FlightServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FlightApplicationTests {

	@Autowired
	private FlightServiceTest flightServiceTest;

	@Test
	void contextLoads() {
		assertNotNull(flightServiceTest);
	}

}
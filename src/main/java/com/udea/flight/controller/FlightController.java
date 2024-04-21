package com.udea.flight.controller;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public List<FlightDTO> searchFlights(
            @RequestParam("originCity") City originCity,
            @RequestParam("destinationCity") City destinationCity,
            @RequestParam("departureDate") LocalDate departureDate,
            @RequestParam("arrivalDate") LocalDate arrivalDate,
            @RequestParam("flightClass") FlightClass flightClass,
            @RequestParam("numberOfPeople") int numberOfPeople
    ) {
        return flightService.searchFlights(originCity, destinationCity, departureDate, arrivalDate, flightClass, numberOfPeople);
    }
}
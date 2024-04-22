package com.udea.flight.controller;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(@RequestParam String originCityName,
                                                         @RequestParam String destinationCityName,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate,
                                                         @RequestParam String flightClassName,
                                                         @RequestParam int numberOfPeople) {
        List<FlightDTO> flights = flightService.searchFlights(originCityName, destinationCityName, departureDate, arrivalDate, flightClassName, numberOfPeople);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }
}

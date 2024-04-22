package com.udea.flight.service;

import com.udea.flight.domain.dto.FlightDTO;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<FlightDTO> searchFlights(String originCityName, String destinationCityName, LocalDate departureDate, LocalDate arrivalDate, String flightClassName, int numberOfPeople);
}
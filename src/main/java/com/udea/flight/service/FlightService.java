package com.udea.flight.service;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.FlightClass;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    List<FlightDTO> searchFlights(City originCity, City destinationCity, LocalDate departureDate, LocalDate arrivalDate, FlightClass flightClass, int numberOfPeople);
}

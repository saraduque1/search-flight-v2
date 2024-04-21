package com.udea.flight.service.impl;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.mapper.FlightMapper;
import com.udea.flight.repository.FlightRepository;
import com.udea.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<FlightDTO> searchFlights(City originCity, City destinationCity, LocalDate departureDate, LocalDate arrivalDate, FlightClass flightClass, int numberOfPeople) {
        List<Flight> flights = flightRepository.findFlights(originCity.getCityName(), destinationCity.getCityName(), departureDate, arrivalDate, flightClass.getNameTypeClass(), numberOfPeople);
        return flights.stream()
                .map(flight -> FlightMapper.mapToFlightDTO(flight, numberOfPeople))
                .toList();
    }
}
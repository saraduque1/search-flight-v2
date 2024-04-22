package com.udea.flight.service.impl;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.mapper.FlightMapper;
import com.udea.flight.repository.CityRepository;
import com.udea.flight.repository.FlightClassRepository;
import com.udea.flight.repository.FlightRepository;
import com.udea.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

    private FlightRepository flightRepository;
    private CityRepository cityRepository;
    private FlightClassRepository flightClassRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, CityRepository cityRepository, FlightClassRepository flightClassRepository) {
        this.flightRepository = flightRepository;
        this.cityRepository = cityRepository;
        this.flightClassRepository = flightClassRepository;
    }

    @Override
    public List<FlightDTO> searchFlights(String originCityName, String destinationCityName, LocalDate departureDate, LocalDate arrivalDate, String flightClassName, int numberOfPeople) {
        City originCity = cityRepository.findByCityName(originCityName);
        City destinationCity = cityRepository.findByCityName(destinationCityName);
        FlightClass flightClass = flightClassRepository.findByNameTypeClass(flightClassName);

        if (originCity == null || destinationCity == null || flightClass == null) {
            logger.warn("Una o más entidades requeridas no encontradas para la búsqueda de vuelos.");
            return Collections.emptyList();
        }

        List<Flight> flights = flightRepository.findFlights(originCity.getCityName(), destinationCity.getCityName(), departureDate, arrivalDate, flightClass.getNameTypeClass(), numberOfPeople);

        if (flights.isEmpty()) {
            logger.info("No se han encontrado vuelos que coincidan con los criterios de búsqueda.");
            return Collections.emptyList();
        }

        return flights.stream()
                .map(flight -> FlightMapper.mapToFlightDTO(flight, numberOfPeople, originCity, destinationCity, flightClass))
                .toList();
    }
}


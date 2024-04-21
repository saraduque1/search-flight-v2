package com.udea.flight.service.impl;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl flightSearchService;

    @Mock
    private FlightRepository flightRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchFlightsByDepartureDate() {
        String originCity = "OriginCity";
        String destinationCity = "DestinationCity";
        LocalDate departureDate = LocalDate.now();

        Flight flight = new Flight();
        flight.setOriginCity(originCity);
        flight.setDestinationCity(destinationCity);
        flight.setDepartureDate(departureDate);

        when(flightRepository.findFlightsByDepartureDate(originCity, destinationCity, departureDate))
                .thenReturn(Arrays.asList(flight));

        List<FlightDTO> result = flightSearchService.searchFlightsByDepartureDate(originCity, destinationCity, departureDate);

        assertEquals(1, result.size());
        FlightDTO resultFlight = result.get(0);
        assertEquals(originCity, resultFlight.getOriginCity());
        assertEquals(destinationCity, resultFlight.getDestinationCity());
        assertEquals(departureDate, resultFlight.getDepartureDate());
    }

    @Test
    void testSearchFlightsByDepartureAndArrivalDate() {
        String originCity = "OriginCity";
        String destinationCity = "DestinationCity";
        LocalDate departureDate = LocalDate.now();
        LocalDate arrivalDate = LocalDate.now().plusDays(5);

        Flight flight = new Flight();
        flight.setOriginCity(originCity);
        flight.setDestinationCity(destinationCity);
        flight.setDepartureDate(departureDate);
        flight.setArrivalDate(arrivalDate);

        when(flightRepository.findFlightsByDepartureAndArrivalDate(originCity, destinationCity, departureDate, arrivalDate))
                .thenReturn(Arrays.asList(flight));

        List<FlightDTO> result = flightSearchService.searchFlightsByDepartureAndArrivalDate(originCity, destinationCity, departureDate, arrivalDate);

        assertEquals(1, result.size());
        FlightDTO resultFlight = result.get(0);
        assertEquals(originCity, resultFlight.getOriginCity());
        assertEquals(destinationCity, resultFlight.getDestinationCity());
        assertEquals(departureDate, resultFlight.getDepartureDate());
        assertEquals(arrivalDate, resultFlight.getArrivalDate());
    }

    @Test
    void testSearchFlightsByOriginAndDestination() {
        String originCity = "OriginCity";
        String destinationCity = "DestinationCity";

        Flight flight = new Flight();
        flight.setOriginCity(originCity);
        flight.setDestinationCity(destinationCity);

        when(flightRepository.findFlightsByOriginAndDestination(originCity, destinationCity))
                .thenReturn(Arrays.asList(flight));

        List<FlightDTO> result = flightSearchService.searchFlightsByOriginAndDestination(originCity, destinationCity);

        assertEquals(1, result.size());
        FlightDTO resultFlight = result.get(0);
        assertEquals(originCity, resultFlight.getOriginCity());
        assertEquals(destinationCity, resultFlight.getDestinationCity());
    }

    @Test
    void testSearchFlightsByPrice() {
        Double price = 100.0;

        Flight flight = new Flight();
        flight.setPrice(price);

        when(flightRepository.findFlightsByPrice(price))
                .thenReturn(Arrays.asList(flight));

        List<FlightDTO> result = flightSearchService.searchFlightsByPrice(price);

        assertEquals(1, result.size());
        FlightDTO resultFlight = result.get(0);
        assertEquals(price, resultFlight.getPrice());
    }
}
package com.udea.flight.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.repository.CityRepository;
import com.udea.flight.repository.FlightClassRepository;
import com.udea.flight.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private FlightClassRepository flightClassRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @Test
    public void testSearchFlights_AllEntitiesFound_FlightsAvailable() {
        City city = new City();
        city.setCityName("SomeCityName"); // Ensure properties are set if they affect logic
        FlightClass flightClass = new FlightClass();
        flightClass.setNameTypeClass("Economy");

        List<Flight> flights = List.of(new Flight());

        // Use more specific matchers or ensure properties are set so objects match expectations
        when(cityRepository.findByCityName(eq("New York"))).thenReturn(city);
        when(cityRepository.findByCityName(eq("Los Angeles"))).thenReturn(city);
        when(flightClassRepository.findByNameTypeClass(eq("Economy"))).thenReturn(flightClass);
        when(flightRepository.findFlights(eq(city.getCityName()), eq(city.getCityName()), any(LocalDate.class), any(LocalDate.class), eq(flightClass.getNameTypeClass()), eq(1))).thenReturn(flights);

        List<FlightDTO> result = flightService.searchFlights("New York", "Los Angeles", LocalDate.now(), LocalDate.now().plusDays(1), "Economy", 1);

        assertFalse(result.isEmpty());
        verify(flightRepository).findFlights(anyString(), anyString(), any(), any(), anyString(), anyInt());
    }


    @Test
    public void testSearchFlights_EntityNotFound() {
        when(cityRepository.findByCityName("New York")).thenReturn(null);

        List<FlightDTO> result = flightService.searchFlights("New York", "Los Angeles", LocalDate.now(), LocalDate.now().plusDays(1), "Economy", 1);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchFlights_NoFlightsFound() {
        City city = new City();
        FlightClass flightClass = new FlightClass();

        when(cityRepository.findByCityName("New York")).thenReturn(city);
        when(cityRepository.findByCityName("Los Angeles")).thenReturn(city);
        when(flightClassRepository.findByNameTypeClass("Economy")).thenReturn(flightClass);
        when(flightRepository.findFlights(anyString(), anyString(), any(), any(), anyString(), anyInt())).thenReturn(Collections.emptyList());

        List<FlightDTO> result = flightService.searchFlights("New York", "Los Angeles", LocalDate.now(), LocalDate.now().plusDays(1), "Economy", 1);

        assertTrue(result.isEmpty());
    }
}


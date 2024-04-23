package com.udea.flight.service.impl;


import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.repository.CityRepository;
import com.udea.flight.repository.FlightClassRepository;
import com.udea.flight.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FlightServiceImplTest {

    @MockBean
    private FlightRepository flightRepository;

    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private FlightClassRepository flightClassRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchFlights() {
        // Preparar datos de prueba
        String originCityName = "New York";
        String destinationCityName = "Los Angeles";
        LocalDate departureDate = LocalDate.now();
        LocalDate arrivalDate = departureDate.plusDays(1);
        String flightClassName = "Economy";
        int numberOfPeople = 2;

        City originCity = new City();
        originCity.setCityName(originCityName);
        City destinationCity = new City();
        destinationCity.setCityName(destinationCityName);
        FlightClass flightClass = new FlightClass();
        flightClass.setNameTypeClass(flightClassName);

        Flight flight = new Flight();
        flight.setAirline("AirlineName");
        flight.setDepartureDate(departureDate);
        flight.setArrivalDate(arrivalDate);
        flight.setAvailableSeats(10);
        flight.setFlightClass(flightClass);

        // Configurar mocks
        when(cityRepository.findByCityName(originCityName)).thenReturn(originCity);
        when(cityRepository.findByCityName(destinationCityName)).thenReturn(destinationCity);
        when(flightClassRepository.findByNameTypeClass(flightClassName)).thenReturn(flightClass);
        when(flightRepository.findFlights(anyString(), anyString(), any(LocalDate.class), any(LocalDate.class), anyString(), anyInt())).thenReturn(Collections.singletonList(flight));

        // Llamar al método a probar
        List<FlightDTO> result = flightService.searchFlights(originCityName, destinationCityName, departureDate, arrivalDate, flightClassName, numberOfPeople);

        // Verificar resultados
        assertEquals(1, result.size());
        FlightDTO flightDTO = result.get(0);
        assertEquals(flight.getAirline(), flightDTO.getAirline());
        assertEquals(flight.getDepartureDate(), flightDTO.getDepartureDate());
        assertEquals(flight.getArrivalDate(), flightDTO.getArrivalDate());
        assertEquals(originCity.getCityName(), flightDTO.getOriginCity());
        assertEquals(destinationCity.getCityName(), flightDTO.getDestinationCity());
        assertEquals(flightClass.getNameTypeClass(), flightDTO.getFlightClass());
        assertEquals(flight.getAvailableSeats(), flightDTO.getAvailableSeats());
    }
}



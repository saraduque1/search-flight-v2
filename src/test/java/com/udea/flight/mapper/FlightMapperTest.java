package com.udea.flight.mapper;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.util.PriceCalculationUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightMapperTest {

    @Test
    public void testMapToFlightDTO() {
        // Crear instancias de Flight, City, y FlightClass
        Flight flight = new Flight();
        flight.setAirline("AirlineName");
        flight.setDepartureDate(LocalDate.now());
        flight.setArrivalDate(LocalDate.now().plusDays(1));
        flight.setAvailableSeats(10);

        // Asegurarse de que el objeto Flight tenga una instancia de FlightClass asignada
        FlightClass flightClass = new FlightClass();
        flightClass.setNameTypeClass("Economy");
        flightClass.setPrice(BigDecimal.valueOf(100.0));
        flight.setFlightClass(flightClass); // Asignar la instancia de FlightClass al objeto Flight

        City originCity = new City();
        originCity.setCityName("OriginCityName");

        City destinationCity = new City();
        destinationCity.setCityName("DestinationCityName");

        // Suponiendo que PriceCalculationUtil.calculateTotalPrice es un método estático
        // que toma el precio de la clase de vuelo y el número de personas y devuelve el precio total.
        BigDecimal expectedTotalPrice = PriceCalculationUtil.calculateTotalPrice(flightClass.getPrice(), 2);

        // Utilizar FlightMapper para convertir los objetos a FlightDTO
        FlightDTO flightDTO = FlightMapper.mapToFlightDTO(flight, 2, originCity, destinationCity, flightClass);

        // Verificar que los datos se han mapeado correctamente
        assertEquals(flight.getAirline(), flightDTO.getAirline());
        assertEquals(flight.getDepartureDate(), flightDTO.getDepartureDate());
        assertEquals(flight.getArrivalDate(), flightDTO.getArrivalDate());
        assertEquals(originCity.getCityName(), flightDTO.getOriginCity());
        assertEquals(destinationCity.getCityName(), flightDTO.getDestinationCity());
        assertEquals(flightClass.getNameTypeClass(), flightDTO.getFlightClass());
        assertEquals(flight.getAvailableSeats(), flightDTO.getAvailableSeats());
        assertEquals(expectedTotalPrice, flightDTO.getTotalPrice());
    }

}


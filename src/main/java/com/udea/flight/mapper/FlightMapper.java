package com.udea.flight.mapper;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.util.PriceCalculationUtil;

import java.math.BigDecimal;

public class FlightMapper {
    public static FlightDTO mapToFlightDTO(Flight flight, int numberOfPeople, City originCity, City destinationCity, FlightClass flightClass) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setOriginCity(originCity.getCityName());
        flightDTO.setDestinationCity(destinationCity.getCityName());
        flightDTO.setFlightClass(flightClass.getNameTypeClass());
        flightDTO.setAvailableSeats(flight.getAvailableSeats());

        BigDecimal price = flight.getFlightClass().getPrice();
        if (price == null) {
            // Opción 1: Lanzar una excepción si el precio es null
            price = BigDecimal.ZERO;

            // Opción 2: Asignar un valor predeterminado si el precio es null
            // price = BigDecimal.ZERO; // O cualquier otro valor predeterminado
        }
        flightDTO.setTotalPrice(PriceCalculationUtil.calculateTotalPrice(price, numberOfPeople));
        return flightDTO;
    }

}

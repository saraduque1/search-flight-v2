package com.udea.flight.mapper;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.util.PriceCalculationUtil;

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
        flightDTO.setTotalPrice(PriceCalculationUtil.calculateTotalPrice(flight.getFlightClass().getPrice(), numberOfPeople));
        return flightDTO;
    }
}

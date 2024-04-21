package com.udea.flight.mapper;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.Flight;
import com.udea.flight.util.PriceCalculationUtil;

import static com.udea.flight.mapper.CityMapper.mapToCityDTO;
import static com.udea.flight.mapper.FlightClassMapper.mapToFlightClassDTO;

public class FlightMapper {

    private FlightMapper() {
        // Prevent instantiation
    }

    public static FlightDTO mapToFlightDTO(Flight flight, int numberOfPeople) {
        if (flight == null) {
            return null;
        }

        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightId(flight.getFlightId());
        flightDTO.setOriginCity(mapToCityDTO(flight.getOriginCity()));
        flightDTO.setDestinationCity(mapToCityDTO(flight.getDestinationCity()));
        flightDTO.setFlightClass(mapToFlightClassDTO(flight.getFlightClass()));
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setAvailableSeats(flight.getAvailableSeats());
        flightDTO.setTotalPrice(PriceCalculationUtil.calculateTotalPrice(flight.getFlightClass().getPrice(), numberOfPeople));

        return flightDTO;
    }
}
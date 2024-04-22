package com.udea.flight.mapper;

import com.udea.flight.domain.dto.FlightClassDTO;
import com.udea.flight.domain.model.FlightClass;

public class FlightClassMapper {

    private FlightClassMapper() {
        // Prevent instantiation
    }

    public static FlightClassDTO mapToFlightClassDTO(FlightClass flightClass) {
        FlightClassDTO flightClassDTO = new FlightClassDTO();
        flightClassDTO.setNameTypeClass(flightClass.getNameTypeClass());
        flightClassDTO.setPrice(flightClass.getPrice());

        return flightClassDTO;
    }
}
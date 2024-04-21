package com.udea.flight.domain.dto;

import com.udea.flight.domain.model.City;
import com.udea.flight.domain.model.FlightClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightDTO {
    private Long flightId;
    private CityDTO originCity;
    private CityDTO destinationCity;
    private FlightClassDTO flightClass;
    private String airline;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer availableSeats;
    private BigDecimal totalPrice; // New field for the total price
}
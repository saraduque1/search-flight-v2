package com.udea.flight.domain.dto;

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
    private String originCity;
    private String destinationCity;
    private String flightClass;
    private String airline;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer availableSeats;
    private BigDecimal totalPrice; // New field for the total price
}

package com.udea.flight.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScaleDTO {
    private Long scaleId;
    private Integer scaleOrder;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private CityDTO city; // Assuming you have a CityDTO class
    private FlightDTO flight; // Assuming you have a FlightDTO class
}


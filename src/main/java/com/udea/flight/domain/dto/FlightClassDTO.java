package com.udea.flight.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightClassDTO {
    private Long flightClassId;
    private String nameTypeClass;
    private BigDecimal price;
}

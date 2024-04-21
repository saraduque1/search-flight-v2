package com.udea.flight.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Flight_Classes")
public class FlightClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight_class")
    private Long flightClassId;

    @Column(name = "name_type_class", nullable = false, length = 50)
    private String nameTypeClass;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}

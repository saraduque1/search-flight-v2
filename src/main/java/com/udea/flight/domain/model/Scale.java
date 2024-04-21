package com.udea.flight.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Scales")
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scale")
    private Long scaleId;

    @Column(name = "id_city", nullable = false)
    private Long idCity;

    @Column(name = "id_flight", nullable = false)
    private Long idFlight;

    @Column(name = "scale_order", nullable = false)
    private Integer scaleOrder;

    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;

    // Assuming that Cities and Flight are other entities in your application
    @ManyToOne
    @JoinColumn(name = "id_city", insertable = false, updatable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_flight", insertable = false, updatable = false)
    private Flight flight;
}
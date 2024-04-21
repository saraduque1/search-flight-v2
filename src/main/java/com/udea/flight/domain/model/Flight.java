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
@Table(name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Long flightId;

    @Column(name = "id_origin", nullable = false)
    private Long idOrigin;

    @Column(name = "id_destination", nullable = false)
    private Long idDestination;

    @Column(name = "id_flight_class", nullable = false)
    private Long idFlightClass;

    @Column(name = "flight_number", nullable = false, length = 6)
    private String flightNumber;

    @Column(name = "airline", nullable = false, length = 50)
    private String airline;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    // Assuming that Cities and FlightClasses are other entities in your application
    @ManyToOne
    @JoinColumn(name = "id_origin", insertable = false, updatable = false)
    private City originCity;

    @ManyToOne
    @JoinColumn(name = "id_destination", insertable = false, updatable = false)
    private City destinationCity;

    @ManyToOne
    @JoinColumn(name = "id_flight_class", insertable = false, updatable = false)
    private FlightClass flightClass;
}

package com.udea.flight.repository;

import com.udea.flight.domain.dto.FlightDTO;
import com.udea.flight.domain.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f.airline as airline, f.departureDate as departureDate, " +
            "f.arrivalDate as arrivalDate, fc.price as price, oc.cityName as originCityName, " +
            "dc.cityName as destinationCityName, fc.nameTypeClass as flightClassName " +
            "FROM Flight f JOIN f.originCity oc JOIN f.destinationCity dc JOIN f.flightClass fc " +
            "WHERE oc.cityName = :origin AND dc.cityName = :destination AND " +
            "f.departureDate = :departureDate AND f.arrivalDate = :arrivalDate AND " +
            "fc.nameTypeClass = :flightClass AND f.availableSeats >= :numberOfPassengers " +
            "ORDER BY fc.price, f.airline")
    List<Flight> findFlights(@Param("origin") String origin,
                                @Param("destination") String destination,
                                @Param("departureDate") LocalDate departureDate,
                                @Param("arrivalDate") LocalDate arrivalDate,
                                @Param("flightClass") String flightClass,
                                @Param("numberOfPassengers") int numberOfPassengers);

}

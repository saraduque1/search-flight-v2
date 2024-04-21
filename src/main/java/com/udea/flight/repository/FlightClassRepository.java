package com.udea.flight.repository;

import com.udea.flight.domain.model.FlightClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightClassRepository extends JpaRepository<FlightClass, Long> {
}

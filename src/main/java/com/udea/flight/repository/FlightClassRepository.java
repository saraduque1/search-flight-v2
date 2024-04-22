package com.udea.flight.repository;

import com.udea.flight.domain.model.FlightClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightClassRepository extends JpaRepository<FlightClass, Long> {
    @Query("SELECT fc FROM FlightClass fc WHERE fc.nameTypeClass = :nameTypeClass")
    FlightClass findByNameTypeClass(@Param("nameTypeClass") String nameTypeClass);
}

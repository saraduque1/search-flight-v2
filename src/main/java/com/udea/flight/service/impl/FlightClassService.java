package com.udea.flight.service.impl;

import com.udea.flight.domain.model.FlightClass;
import com.udea.flight.repository.FlightClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightClassService {

    private final FlightClassRepository flightClassRepository;

    @Autowired
    public FlightClassService(FlightClassRepository flightClassRepository) {
        this.flightClassRepository = flightClassRepository;
    }

    public FlightClass getFlightClassByName(String nameTypeClass) {
        return flightClassRepository.findByNameTypeClass(nameTypeClass);
    }
}
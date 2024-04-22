package com.udea.flight.service.impl;

import com.udea.flight.domain.model.City;
import com.udea.flight.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCityByName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }
}
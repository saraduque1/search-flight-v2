package com.udea.flight.mapper;

import com.udea.flight.domain.dto.CityDTO;
import com.udea.flight.domain.model.City;

public class CityMapper {

    private CityMapper() {
        // Prevent instantiation
    }

    public static CityDTO mapToCityDTO(City city) {
        if (city == null) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityId(city.getCityId());
        cityDTO.setCityName(city.getCityName());

        return cityDTO;
    }
}
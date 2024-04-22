package com.udea.flight.repository;

import com.udea.flight.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c FROM City c WHERE c.cityName = :cityName")
    City findByCityName(@Param("cityName") String cityName);
}

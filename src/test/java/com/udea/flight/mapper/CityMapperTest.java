package com.udea.flight.mapper;

import com.udea.flight.domain.dto.CityDTO;
import com.udea.flight.domain.model.City;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityMapperTest {

    @Test
    public void testMapToCityDTO() {
        // Crear una instancia de City
        City city = new City();
        city.setCityId(1L);
        city.setCityName("New York");

        // Utilizar CityMapper para convertir city a CityDTO
        CityDTO cityDTO = CityMapper.mapToCityDTO(city);

        // Verificar que los datos se han mapeado correctamente
        assertEquals(city.getCityId(), cityDTO.getCityId());
        assertEquals(city.getCityName(), cityDTO.getCityName());
    }
}

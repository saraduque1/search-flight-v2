package com.udea.flight.util;

import java.math.BigDecimal;

public class PriceCalculationUtil {
    private PriceCalculationUtil() {
        // Prevenir instanciación
    }

    public static BigDecimal calculateTotalPrice(BigDecimal price, int numberOfPeople) {
        if (price == null) {
            // Manejar el caso en que price es null, por ejemplo, estableciendo un precio predeterminado o lanzando una excepción
            throw new IllegalArgumentException("El precio no puede ser null");
        }
        return price.multiply(BigDecimal.valueOf(numberOfPeople));
    }

}

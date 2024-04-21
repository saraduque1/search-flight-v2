package com.udea.flight.util;

import java.math.BigDecimal;

public class PriceCalculationUtil {
    private PriceCalculationUtil() {
        // Prevenir instanciación
    }

    public static BigDecimal calculateTotalPrice(BigDecimal price, int numberOfPeople) {
        return price.multiply(BigDecimal.valueOf(numberOfPeople));
    }
}

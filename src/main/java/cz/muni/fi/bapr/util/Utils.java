package cz.muni.fi.bapr.util;

import java.math.BigDecimal;

/**
 * Utility functions
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class Utils {

    /**
     * Computes price with vat
     *
     * @param basicPrice basic price
     * @param vat        vat value
     * @return price with vat
     */
    public static BigDecimal getVatPrice(BigDecimal basicPrice, BigDecimal vat) {
        if (basicPrice == null) {
            throw new IllegalArgumentException("Basic price is null");
        }
        if (vat == null) {
            throw new IllegalArgumentException("Vat is null");
        }
        return basicPrice.add(basicPrice.multiply(vat.divide(BigDecimal.valueOf(100)))).setScale(2);
    }

}

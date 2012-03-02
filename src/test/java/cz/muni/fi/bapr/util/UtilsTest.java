package cz.muni.fi.bapr.util;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class UtilsTest {

    @Test
    public void testVatPrice() {
        BigDecimal base = BigDecimal.valueOf(100);
        BigDecimal vat = BigDecimal.valueOf(19);
        assertEquals(BigDecimal.valueOf(119).setScale(2), Utils.getVatPrice(base, vat));

        base = BigDecimal.valueOf(100);
        vat = BigDecimal.valueOf(0);
        assertEquals(BigDecimal.valueOf(100).setScale(2), Utils.getVatPrice(base, vat));

        base = BigDecimal.valueOf(99);
        vat = BigDecimal.valueOf(19);
        assertEquals(BigDecimal.valueOf(117.81).setScale(2), Utils.getVatPrice(base, vat));
    }


}

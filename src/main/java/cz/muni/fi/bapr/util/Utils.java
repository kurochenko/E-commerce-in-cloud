package cz.muni.fi.bapr.util;

import cz.muni.fi.bapr.entity.Cart;

import java.math.BigDecimal;
import java.util.List;

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

    public static void computeCartStats(List<Cart> carts, BigDecimal totalAmount, BigDecimal totalPrice, BigDecimal totalPriceVat) {

        totalAmount = totalPrice = totalPriceVat = BigDecimal.ZERO;

        for (Cart cart : carts) {
            totalAmount = totalAmount.add(BigDecimal.valueOf(cart.getAmount()));

            BigDecimal priceBase = cart.getProduct().getPrice();
            BigDecimal priceWithVat = Utils.getVatPrice(priceBase, cart.getProduct().getVat().getVat());
            BigDecimal amount = BigDecimal.valueOf(cart.getAmount());

            totalPrice = totalPrice.add(priceBase.multiply(amount));
            totalPriceVat = totalPriceVat.add(priceWithVat.multiply(amount));
        }
    }

}

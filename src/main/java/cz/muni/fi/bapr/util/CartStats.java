package cz.muni.fi.bapr.util;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class CartStats {

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private BigDecimal amount = BigDecimal.ZERO;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price = BigDecimal.ZERO;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal priceVat = BigDecimal.ZERO;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceVat() {
        return priceVat;
    }

    public void setPriceVat(BigDecimal priceVat) {
        this.priceVat = priceVat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartStats cartStats = (CartStats) o;

        if (amount != null ? !amount.equals(cartStats.amount) : cartStats.amount != null) return false;
        if (price != null ? !price.equals(cartStats.price) : cartStats.price != null) return false;
        if (priceVat != null ? !priceVat.equals(cartStats.priceVat) : cartStats.priceVat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceVat != null ? priceVat.hashCode() : 0);
        return result;
    }
}

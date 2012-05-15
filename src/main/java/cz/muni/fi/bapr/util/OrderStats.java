package cz.muni.fi.bapr.util;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

/**
 * Serves for retrieval of statistics about order from database
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class OrderStats {

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

        OrderStats orderStats = (OrderStats) o;

        if (amount != null ? !amount.equals(orderStats.amount) : orderStats.amount != null) return false;
        if (price != null ? !price.equals(orderStats.price) : orderStats.price != null) return false;
        if (priceVat != null ? !priceVat.equals(orderStats.priceVat) : orderStats.priceVat != null) return false;

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

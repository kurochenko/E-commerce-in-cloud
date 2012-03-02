package cz.muni.fi.bapr.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Entity
public class Vat implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.min}")
    @Max(value = 100, message = "{validation.max}")
    @NumberFormat
    private BigDecimal vat;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vat vat1 = (Vat) o;

        if (id != null ? !id.equals(vat1.id) : vat1.id != null) return false;
        if (vat != null ? !vat.equals(vat1.vat) : vat1.vat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        return result;
    }
}

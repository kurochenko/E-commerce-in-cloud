package cz.muni.fi.bapr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Entity
public class Vat implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "{validation.empty}")
    @Size(min = 0, max = 100, message = "{validation.size}")
    private Integer vat;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
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

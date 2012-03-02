package cz.muni.fi.bapr.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Entity
public class Product implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 255, message = "{validation.length}")
    private String name;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 1024, message = "{validation.length.max}")
    private String description;

    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.min}")
    @NumberFormat
    private BigDecimal price;

    @NotNull(message = "{validation.empty}")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @NotNull
    @Min(value = 0, message = "{validation.min}")
    private Integer amount;

    @NotNull(message = "{validation.empty}")
    @ManyToOne
    private Vat vat;

    @NotNull(message = "{validation.empty}")
    @ManyToOne
    private Category category;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (amount != null ? !amount.equals(product.amount) : product.amount != null) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (created != null ? !created.equals(product.created) : product.created != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (vat != null ? !vat.equals(product.vat) : product.vat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}

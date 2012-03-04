package cz.muni.fi.bapr.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Entity
public class Cart implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @OneToOne
    private Customer customer;

    @NaturalId
    @ManyToOne
    private Product product;

    @NotNull(message = "{validation.empty}")
    @Min(value = 0, message = "{validation.min}")
    private Integer amount;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (amount != null ? !amount.equals(cart.amount) : cart.amount != null) return false;
        if (customer != null ? !customer.equals(cart.customer) : cart.customer != null) return false;
        if (id != null ? !id.equals(cart.id) : cart.id != null) return false;
        if (product != null ? !product.equals(cart.product) : cart.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}

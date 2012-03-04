package cz.muni.fi.bapr.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Entity(name = "Orders")
public class Order implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "{validation.empty}")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date attended;

    @NotNull(message = "{validation.empty}")
    @ManyToOne
    private Customer customer;

    @NotNull(message = "{validation.empty}")
    @ManyToOne
    private DeliveryType deliveryType;

    @NotNull(message = "{validation.empty}")
    @ManyToOne
    private PaymentType paymentType;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getAttended() {
        return attended;
    }

    public void setAttended(Date attended) {
        this.attended = attended;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (attended != null ? !attended.equals(order.attended) : order.attended != null) return false;
        if (created != null ? !created.equals(order.created) : order.created != null) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (deliveryType != null ? !deliveryType.equals(order.deliveryType) : order.deliveryType != null) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (paymentType != null ? !paymentType.equals(order.paymentType) : order.paymentType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (attended != null ? attended.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (deliveryType != null ? deliveryType.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        return result;
    }
}

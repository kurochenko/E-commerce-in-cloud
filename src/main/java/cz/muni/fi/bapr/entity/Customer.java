package cz.muni.fi.bapr.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Entity
public class Customer implements Serializable, IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{validation.empty}")
    @Email(message = "{customer.validation.email.pattern}")
    @Length(max = 255, message = "{validation.length.max}")
    private String email;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 255, message = "{validation.length.max}")
    private String password;

    @NotNull(message = "{validation.empty}")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 255, message = "{validation.length.max}")
    private String name;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 255, message = "{validation.length.max}")
    private String city;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 255, message = "{validation.length.max}")
    private String street;

    @NotEmpty(message = "{validation.empty}")
    @Length(max = 255, message = "{validation.length.max}")
    private String zipCode;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserPrivilege> privileges;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<UserPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<UserPrivilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (created != null ? !created.equals(customer.created) : customer.created != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;
        if (privileges != null ? !privileges.equals(customer.privileges) : customer.privileges != null) return false;
        if (street != null ? !street.equals(customer.street) : customer.street != null) return false;
        if (zipCode != null ? !zipCode.equals(customer.zipCode) : customer.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        return result;
    }
}

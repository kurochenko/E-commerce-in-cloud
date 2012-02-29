package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.PaymentType;

/**
 * DAO interface for {@code PaymentType} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface PaymentTypeDAO extends DAOTemplate<PaymentType> {

    /**
     * Searches for {@code PaymentType} with given unique name
     *
     * @param name name of payment type
     * @return {@code PaymentType} or {@code null} when no payment type was found with specified name
     */
    PaymentType findByName(String name);

}

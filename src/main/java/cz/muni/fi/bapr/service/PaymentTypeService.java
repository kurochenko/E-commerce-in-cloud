package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.PaymentType;

/**
 * Service interface for {@code PaymentType} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface PaymentTypeService extends ServiceTemplate<PaymentType> {

    /**
     * Searches for {@code Category} with given unique name
     *
     * @param name name of category
     * @return {@code Category} or {@code null} when no category was found with specified name
     */
    PaymentType findByName(String name);
}

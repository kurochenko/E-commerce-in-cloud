package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.DeliveryType;

/**
 * Service interface for {@code DeliveryType} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface DeliveryTypeService extends ServiceTemplate<DeliveryType> {

    /**
     * Searches for {@code Category} with given unique name
     *
     * @param name name of category
     * @return {@code Category} or {@code null} when no category was found with specified name
     */
    DeliveryType findByName(String name);
}

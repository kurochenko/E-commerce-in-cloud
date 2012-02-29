package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.DeliveryType;

/**
 * DAO interface for {@code DeliveryType} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface DeliveryTypeDAO extends DAOTemplate<DeliveryType> {

    /**
     * Searches for {@code DeliveryType} with given unique name
     *
     * @param name name of delivery type
     * @return {@code DeliveryType} or {@code null} when no delivery type was found with specified name
     */
    DeliveryType findByName(String name);

}

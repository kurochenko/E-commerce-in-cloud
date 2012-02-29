package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.DeliveryTypeDAO;
import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code DeliveryTypeService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class DeliveryTypeServiceImpl extends AbstractServiceImpl<DeliveryType, DeliveryTypeDAO> implements DeliveryTypeService {

    @Autowired
    private DeliveryTypeDAO deliveryTypeDAO;


    @Override
    public DeliveryTypeDAO getDao() {
        return deliveryTypeDAO;
    }

    @Override
    public void create(DeliveryType entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Delivery type is null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Delivery type ID is not null");
        }
        if ((deliveryTypeDAO.findByName(entity.getName())) != null) {
            throw new IllegalArgumentException("Delivery type with name '" + entity.getName() + "' already exists");
        }

        deliveryTypeDAO.create(entity);
    }

    @Override
    public void edit(DeliveryType entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Delivery type is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Delivery type ID is null");
        }

        DeliveryType deliveryType = deliveryTypeDAO.findByName(entity.getName());

        if ((deliveryType != null) && !deliveryType.getId().equals(entity.getId())) {
            throw new IllegalArgumentException("Delivery type with name '" + entity.getName() + "' already exists");
        }

        deliveryTypeDAO.edit(entity);
    }

    @Override
    public DeliveryType findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Delivery type name is null");
        }

        return deliveryTypeDAO.findByName(name);
    }
}

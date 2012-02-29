package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.PaymentTypeDAO;
import cz.muni.fi.bapr.entity.PaymentType;
import cz.muni.fi.bapr.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code PaymentTypeService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class PaymentTypeServiceImpl extends AbstractServiceImpl<PaymentType, PaymentTypeDAO> implements PaymentTypeService {

    @Autowired
    private PaymentTypeDAO paymentTypeDAO;


    @Override
    public PaymentTypeDAO getDao() {
        return paymentTypeDAO;
    }

    @Override
    public void create(PaymentType entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Payment type is null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Payment type ID is not null");
        }
        if ((paymentTypeDAO.findByName(entity.getName())) != null) {
            throw new IllegalArgumentException("Payment type with name '" + entity.getName() + "' already exists");
        }

        paymentTypeDAO.create(entity);
    }

    @Override
    public void edit(PaymentType entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Payment type is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Payment type ID is null");
        }

        PaymentType paymentType = paymentTypeDAO.findByName(entity.getName());

        if ((paymentType != null) && !paymentType.getId().equals(entity.getId())) {
            throw new IllegalArgumentException("Payment type with name '" + entity.getName() + "' already exists");
        }

        paymentTypeDAO.edit(entity);
    }

    @Override
    public PaymentType findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Payment type name is null");
        }

        return paymentTypeDAO.findByName(name);
    }
}

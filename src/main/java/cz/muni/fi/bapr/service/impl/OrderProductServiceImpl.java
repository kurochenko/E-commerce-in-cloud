package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.OrderProduct;
import cz.muni.fi.bapr.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code OrderProductService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class OrderProductServiceImpl extends AbstractServiceImpl<OrderProduct, OrderProductDAO> implements OrderProductService {

    @Autowired
    private OrderProductDAO orderProductDAO;


    @Override
    public OrderProductDAO getDao() {
        return orderProductDAO;
    }
}

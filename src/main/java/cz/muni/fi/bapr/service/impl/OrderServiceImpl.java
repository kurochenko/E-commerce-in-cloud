package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.OrderDAO;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code OrderService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderDAO> implements OrderService {

    @Autowired
    private OrderDAO orderDAO;


    @Override
    public OrderDAO getDao() {
        return orderDAO;
    }
}

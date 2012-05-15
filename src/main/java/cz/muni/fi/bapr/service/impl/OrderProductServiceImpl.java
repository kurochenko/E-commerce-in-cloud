package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.OrderProductDAO;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.OrderProduct;
import cz.muni.fi.bapr.service.OrderProductService;
import cz.muni.fi.bapr.util.OrderStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public List<OrderProduct> findByOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order is null");
        }

        return orderProductDAO.findByOrder(order);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderStats sumStats(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order is null");
        }

        return orderProductDAO.sumStats(order);
    }
}

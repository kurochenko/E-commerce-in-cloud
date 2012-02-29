package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.CartDAO;
import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code CartService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class CartServiceImpl extends AbstractServiceImpl<Cart, CartDAO> implements CartService {

    @Autowired
    private CartDAO cartDAO;


    @Override
    public CartDAO getDao() {
        return cartDAO;
    }
}

package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.CartProductDAO;
import cz.muni.fi.bapr.entity.CartProduct;
import cz.muni.fi.bapr.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code CartProductService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class CartProductServiceImpl extends AbstractServiceImpl<CartProduct, CartProductDAO> implements CartProductService {

    @Autowired
    private CartProductDAO cartProductDAO;


    @Override
    public CartProductDAO getDao() {
        return cartProductDAO;
    }
}

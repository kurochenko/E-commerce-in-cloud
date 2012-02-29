package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.CartProductDAO;
import cz.muni.fi.bapr.entity.CartProduct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class CartProductDAOImpl extends AbstractDAOImpl<CartProduct> implements CartProductDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public CartProductDAOImpl() {
        super(CartProduct.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

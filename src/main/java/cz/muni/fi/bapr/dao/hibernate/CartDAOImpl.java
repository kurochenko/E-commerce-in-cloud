package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.CartDAO;
import cz.muni.fi.bapr.entity.Cart;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class CartDAOImpl extends AbstractDAOImpl<Cart> implements CartDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public CartDAOImpl() {
        super(Cart.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

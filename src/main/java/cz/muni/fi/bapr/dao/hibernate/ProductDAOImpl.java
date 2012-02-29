package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Component
public class ProductDAOImpl extends AbstractDAOImpl<Product> implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public ProductDAOImpl() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

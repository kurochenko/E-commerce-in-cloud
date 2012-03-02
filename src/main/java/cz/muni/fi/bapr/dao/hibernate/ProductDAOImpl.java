package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
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

    @Override
    public List<Product> findByCategory(Category category) {

        List<Product> result = new ArrayList<Product>();
        try {
            Query query = getEntityManager().createQuery("from Product p where p.category = :category ");
            query.setParameter("category", category);
            result = query.getResultList();
        } catch (NoResultException e) {
        }
        return result;
    }
}

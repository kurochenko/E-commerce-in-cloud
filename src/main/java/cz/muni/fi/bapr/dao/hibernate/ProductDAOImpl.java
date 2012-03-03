package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.ProductDAO;
import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.entity.Vat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return super.findListByParam("category", category);
    }

    @Override
    public List<Product> findByVat(Vat vat) {
        return super.findListByParam("vat", vat);
    }
}

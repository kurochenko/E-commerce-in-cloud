package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.CategoryDAO;
import cz.muni.fi.bapr.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class CategoryDAOImpl extends AbstractDAOImpl<Category> implements CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Category findByName(String name) {
        return super.findByParam("name", name);
    }
}

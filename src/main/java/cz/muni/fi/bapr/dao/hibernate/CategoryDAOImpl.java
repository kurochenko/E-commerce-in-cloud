package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.CategoryDAO;
import cz.muni.fi.bapr.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class CategoryDAOImpl extends AbstractParamSearchDAOImpl<Category> implements CategoryDAO {

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

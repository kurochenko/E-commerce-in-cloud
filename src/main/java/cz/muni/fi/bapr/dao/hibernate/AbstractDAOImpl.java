package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.DAOTemplate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@code DAOTemplate} for generic types
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public abstract class AbstractDAOImpl<T> implements DAOTemplate<T> {

    /**
     * Class type of entity stored as generic
     */
    private Class<T> entityClass;


    /**
     * Constructor which sets Class type of generic T
     *
     * @param entityClass class type of generic T
     */
    public AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Returns class type of generic T
     *
     * @return class type of generic T
     */
    protected Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * Returns entity manager
     *
     * @return entity manager
     */
    protected abstract EntityManager getEntityManager();

    @Override
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T find(Long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findRange(int from, int howMany) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(howMany);
        q.setFirstResult(from);
        return q.getResultList();
    }

    @Override
    public List<T> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e");
        return (List<T>) query.getResultList();
    }

    @Override
    public long count() {
        Query query = getEntityManager().createQuery("SELECT COUNT(c) FROM " + entityClass.getName() + " c");
        return (Long) query.getSingleResult();
    }

    /**
     * Searches for entities specified by generic type T which have parameter {@code parameterName} and value {@code searchValue}
     *
     * @param parameterName parameter name which may contain {@code searchValue}
     * @param searchValue   value to search in {@code parameterName} entity parameter
     * @return {@code T} entity if search matched, {@code null} otherwise
     */
    protected T findByParam(String parameterName, Object searchValue) {
        if (parameterName == null) {
            throw new IllegalArgumentException("Parameter name is null");
        }
        if (searchValue == null) {
            throw new IllegalArgumentException("Search value is null");
        }

        T result = null;

        try {
            Query query = getEntityManager().createQuery("from " + getEntityClass().getName() + " where " + parameterName + " = :param ");
            query.setParameter("param", searchValue);
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
        }
        return result;
    }

    /**
     * Searches for entities specified by generic type T which have parameter {@code parameterName} and value {@code searchValue}
     *
     * @param parameterName parameter name which may contain {@code searchValue}
     * @param searchValue   value to search in {@code parameterName} entity parameter
     * @return {@code List&lt;T&gt;} entity if search matched, empty list otherwise
     */
    protected List<T> findListByParam(String parameterName, Object searchValue) {
        if (parameterName == null) {
            throw new IllegalArgumentException("Parameter name is null");
        }
        if (searchValue == null) {
            throw new IllegalArgumentException("Search value is null");
        }

        List<T> result = new ArrayList<T>();

        try {
            Query query = getEntityManager().createQuery("from " + getEntityClass().getName() + " where " + parameterName + " = :param ");
            query.setParameter("param", searchValue);
            result = query.getResultList();
        } catch (NoResultException e) {
        }
        return result;
    }
}

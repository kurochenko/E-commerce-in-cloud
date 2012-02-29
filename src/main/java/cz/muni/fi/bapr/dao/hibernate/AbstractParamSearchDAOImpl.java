package cz.muni.fi.bapr.dao.hibernate;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public abstract class AbstractParamSearchDAOImpl<T> extends AbstractDAOImpl<T> {


    /**
     * Constructor which sets Class type of generic T
     *
     * @param entityClass class type of generic T
     */
    public AbstractParamSearchDAOImpl(Class<T> entityClass) {
        super(entityClass);
    }

    /**
     * Searches for entities specified by generic type T which have parameter {@code parameterName} and value {@code searchValue}
     *
     * @param parameterName parameter name which may contain {@code searchValue}
     * @param searchValue   value to search in {@code parameterName} entity parameter
     * @return {@code T} entity if search matched, {@code null} otherwise
     */
    protected T findByParam(String parameterName, String searchValue) {
        if (parameterName == null) {
            throw new IllegalArgumentException("Parameter name is null");
        }
        if (searchValue == null) {
            throw new IllegalArgumentException("Search value is null");
        }

        T result = null;

        try {
            Query query = getEntityManager().createQuery("from " + super.getEntityClass().getName() + " where " + parameterName + " = :param ");
            query.setParameter("param", searchValue);
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
        }
        return result;
    }
}

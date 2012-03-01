package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.DAOTemplate;
import cz.muni.fi.bapr.entity.IdentifiedEntity;
import cz.muni.fi.bapr.service.ServiceTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Generic service layer. Centralizes similar code for all service classes
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Transactional
public abstract class AbstractServiceImpl<T extends IdentifiedEntity, K extends DAOTemplate<T>> implements ServiceTemplate<T> {

    /**
     * Returns implementation of {@code DAOTemplate} interface
     *
     * @return implementation of {@code DAOTemplate} interface
     */
    public abstract K getDao();

    @Override
    public void create(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Entity ID is already set");
        }

        getDao().create(entity);
    }

    @Override
    public void edit(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Entity ID is null");
        }

        getDao().edit(entity);
    }

    @Override
    public void remove(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Entity ID is null");
        }

        getDao().remove(entity);
    }

    @Override
    public T find(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Entity ID is null");
        }

        return getDao().find(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public List<T> findRange(int from, int howMany) {
        if (from < 0) {
            throw new IllegalArgumentException("Range parameter 'from' cant be negative");
        }
        if (from > howMany) {
            throw new IllegalArgumentException("Range parameter 'from' cant have greater value than 'howMany'");
        }

        return getDao().findRange(from, howMany);
    }

    @Override
    public long count() {
        return getDao().count();
    }
}

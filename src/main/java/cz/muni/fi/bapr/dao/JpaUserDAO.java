package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@Repository
@Transactional
public class JpaUserDAO implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(User entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        em.persist(entity);
    }

    @Override
    public void edit(User entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        em.merge(entity);
    }

    @Override
    public void remove(User entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        em.remove(em.merge(entity));
    }

    @Override
    public User find(Object id) {
        if (id == null) {
            throw new IllegalArgumentException("Entity ID is null");
        }
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        Query query = em.createQuery("SELECT e FROM User e");
        return (List<User>) query.getResultList();
    }

    @Override
    public long count() {
        Query query = em.createQuery("SELECT COUNT(c) FROM User c");
        return (Long) query.getSingleResult();
    }
}

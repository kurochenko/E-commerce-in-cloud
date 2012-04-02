package cz.muni.fi.bapr.dao.hibernate;

import cz.muni.fi.bapr.dao.UserPrivilegeDAO;
import cz.muni.fi.bapr.entity.UserPrivilege;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Repository
public class UserPrivilegeDAOImpl extends AbstractDAO<UserPrivilege> implements UserPrivilegeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public UserPrivilegeDAOImpl() {
        super(UserPrivilege.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public UserPrivilege findByName(String name) {
        return super.findByParam("name", name);
    }
}

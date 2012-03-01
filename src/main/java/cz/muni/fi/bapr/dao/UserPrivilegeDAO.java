package cz.muni.fi.bapr.dao;

import cz.muni.fi.bapr.entity.UserPrivilege;

/**
 * DAO interface for {@code UserPrivilege} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface UserPrivilegeDAO extends DAOTemplate<UserPrivilege> {

    UserPrivilege findByName(String name);

}

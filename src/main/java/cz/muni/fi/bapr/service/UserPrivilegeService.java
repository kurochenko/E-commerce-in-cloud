package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.UserPrivilege;

/**
 * Service interface for {@code UserPrivilege} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface UserPrivilegeService extends ServiceTemplate<UserPrivilege> {

    UserPrivilege findByName(String name);

}

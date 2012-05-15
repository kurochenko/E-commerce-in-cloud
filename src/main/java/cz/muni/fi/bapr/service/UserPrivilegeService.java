package cz.muni.fi.bapr.service;

import cz.muni.fi.bapr.entity.UserPrivilege;

/**
 * Service interface for {@code UserPrivilege} entity
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public interface UserPrivilegeService extends ServiceTemplate<UserPrivilege> {

    /**
     * Searches for user privilege identified by name
     * @param name
     * @return
     */
    UserPrivilege findByName(String name);
}

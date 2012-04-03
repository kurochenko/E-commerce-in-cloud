package cz.muni.fi.bapr.util;

import cz.muni.fi.bapr.entity.UserPrivilege;
import cz.muni.fi.bapr.security.UserRoles;
import cz.muni.fi.bapr.service.UserPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Initializes application on startup. Inserts necessary values into DB
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class Init {

    @Autowired
    private UserPrivilegeService userPrivilegeService;


    /**
     * Creates special user privileges
     */
    @PostConstruct
    public void initPrivileges() {
        if (userPrivilegeService.count() == 0) {
            UserPrivilege privilege = new UserPrivilege();
            privilege.setName(UserRoles.ROLE_ADMIN);

            userPrivilegeService.create(privilege);
        }
    }
}

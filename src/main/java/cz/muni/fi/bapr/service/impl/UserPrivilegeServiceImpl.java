package cz.muni.fi.bapr.service.impl;

import cz.muni.fi.bapr.dao.UserPrivilegeDAO;
import cz.muni.fi.bapr.entity.UserPrivilege;
import cz.muni.fi.bapr.service.UserPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@code UserPrivilegeService} service interface
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
@Transactional
public class UserPrivilegeServiceImpl extends AbstractServiceImpl<UserPrivilege, UserPrivilegeDAO> implements UserPrivilegeService {

    @Autowired
    private UserPrivilegeDAO userPrivilegeDAO;


    @Override
    public UserPrivilegeDAO getDao() {
        return userPrivilegeDAO;
    }

    @Override
    public void create(UserPrivilege entity) {
        if (entity == null) {
            throw new IllegalArgumentException("User privilege is null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("User privilege ID is not null");
        }
        if ((userPrivilegeDAO.findByName(entity.getName())) != null) {
            throw new IllegalArgumentException("User privilege with name '" + entity.getName() + "' already exists");
        }

        userPrivilegeDAO.create(entity);
    }

    @Override
    public void edit(UserPrivilege entity) {
        if (entity == null) {
            throw new IllegalArgumentException("User privilege is null");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("User privilege ID is null");
        }

        UserPrivilege userPrivilege = userPrivilegeDAO.findByName(entity.getName());

        if ((userPrivilege != null) && !userPrivilege.getId().equals(entity.getId())) {
            throw new IllegalArgumentException("User privilege with name '" + entity.getName() + "' already exists");
        }

        userPrivilegeDAO.edit(entity);
    }

    @Override
    public UserPrivilege findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("User privilege name is null");
        }

        return userPrivilegeDAO.findByName(name);
    }
}

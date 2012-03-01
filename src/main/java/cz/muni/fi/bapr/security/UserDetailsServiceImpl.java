package cz.muni.fi.bapr.security;

import cz.muni.fi.bapr.dao.CustomerDAO;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.UserPrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Custom authentication provider service which retrieves users from custom DAO objects
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerDAO customerDAO;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Customer customer = customerDAO.findByEmail(s);

        if (customer == null) {
            throw new UsernameNotFoundException("User with username '" + s + "' was not found.");
        }

        return customerToUser(customer);
    }

    /**
     * Transforms {@code Customer} entity to {@code User} object
     *
     * @param customer entity to transform
     * @return {@code User object} whose attributes will be populated by {@code Customer} attribute values
     */
    private User customerToUser(Customer customer) {
        User user = new User();
        user.setId(customer.getId());
        user.setUsername(customer.getEmail());
        user.setPassword(customer.getPassword());
        user.addAuthority(UserRoles.ROLE_LOGGED);
        for (UserPrivilege privilege : customer.getPrivileges()) {
            user.addAuthority(privilege.getName());
        }

        return user;
    }
}

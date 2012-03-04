package cz.muni.fi.bapr.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class SecurityUserHolder {

    /**
     * Retrieves {@code SecurityUser} object from users session
     *
     * @return {@code SecurityUser} or {@code null} when user is not logged in
     */
    public static User getSecurityUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getPrincipal().equals("anonymousUser")
                ? new User()
                : (User) auth.getPrincipal();
    }
}

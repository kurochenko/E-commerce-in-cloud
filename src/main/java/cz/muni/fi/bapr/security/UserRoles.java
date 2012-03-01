package cz.muni.fi.bapr.security;

/**
 * Custom user roles used in application
 *
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
public class UserRoles {

    /**
     * This role has non-authenticated user
     */
    public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

    /**
     * This role has authenticated user
     */
    public static final String ROLE_LOGGED = "ROLE_LOGGED";

    /**
     * This role has authenticated user with special privileges
     */
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
}

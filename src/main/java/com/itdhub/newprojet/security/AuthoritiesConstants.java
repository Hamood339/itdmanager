package com.itdhub.newprojet.security;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_ETUDIANT";

    public static final String ETUDIANT;

    public static final String PROFESSEUR;

    static {
        ETUDIANT = "ROLE_ETUDIANT";
        PROFESSEUR = "ROLE_PROFESSEUR";
    }

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {}
}

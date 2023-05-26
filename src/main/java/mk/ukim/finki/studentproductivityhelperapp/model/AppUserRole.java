package mk.ukim.finki.studentproductivityhelperapp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum AppUserRole {
    USER,
    ADMIN;

    public List<GrantedAuthority> getAuthorities() {
        // Create a list to hold the authorities
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Add the role-based authority
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        // Add any additional authorities based on your requirements

        return authorities;
    }
}

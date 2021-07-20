package com.auth.services.auth.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "appuser")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String password;
    private String username;
    private transient boolean accountNonExpired;
    private transient boolean accountNonLocked;
    @Column(name = "active")
    private boolean enabled;
    @Column(name = "roles")
    private String authorities;


    public String getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }


    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }


    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }


    public boolean isCredentialsNonExpired() {
        return false;
    }


    public boolean isEnabled() {
        return enabled;
    }
}

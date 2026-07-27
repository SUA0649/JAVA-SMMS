package com.Shaheer.smms.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "auth_user")
public class AuthUser implements UserDetails {
    public enum Type{
        ADMIN,
        USER,
        VIEWER,
        MANAGER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type role;

    @OneToOne(mappedBy = "authUser", cascade = CascadeType.ALL)
    private Users userProfile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String enumString = this.role.name();

        String springRole = "ROLE_" + enumString;

        return List.of(new SimpleGrantedAuthority(springRole));
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getRole() {
        return role;
    }

    public void setRole(Type role) {
        this.role = role;
    }

    public Users getUser() {
        return userProfile;
    }

    public void setUser(Users user) {
        this.userProfile = user;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}


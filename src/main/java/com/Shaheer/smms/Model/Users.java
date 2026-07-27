package com.Shaheer.smms.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`User_id`")
    private Integer user_id;

    private String name;
    private String email;
    private LocalDateTime createdAt;
    private String role;

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Equipment_Tracking> tracking;

    @JsonIgnore
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Account_Access> access;

    @OneToOne
    @JoinColumn(name = "auth_id", referencedColumnName = "id")
    private AuthUser authUser;

    public List<Equipment_Tracking> getTracking() {
        return tracking;
    }

    public void setTracking(List<Equipment_Tracking> tracking) {
        this.tracking = tracking;
    }

    public List<Account_Access> getAccess() {
        return access;
    }

    public void setAccess(List<Account_Access> access) {
        this.access = access;
    }

    public Users() {
    }

    public Users(Integer user_id, String name, String email, LocalDateTime createdAt, String role, List<Equipment_Tracking> tracking, List<Account_Access> access) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.role = role;
        this.tracking = tracking;
        this.access = access;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package com.Shaheer.smms.Model;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`User_id`")
    private int User_id;

    private String Name;
    private String Email;
    private Date CreatedAt;
    private String Role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Equipment_Tracking> tracking;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Account_Access> access;


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

    public Users(int user_id, String name, String email, Date createdAt, String role, List<Equipment_Tracking> tracking, List<Account_Access> access) {
        User_id = user_id;
        Name = name;
        Email = email;
        CreatedAt = createdAt;
        Role = role;
        this.tracking = tracking;
        this.access = access;
    }



    public Users() {

    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}

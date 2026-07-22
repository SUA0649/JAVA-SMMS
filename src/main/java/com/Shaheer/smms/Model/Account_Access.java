package com.Shaheer.smms.Model;

import jakarta.persistence.*;

@Entity
@Table(name="`Account Access`")
public class Account_Access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Access_id")
    private Integer access_id;
    // User_id
    //Account_id1
    private String permission_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`User_id`")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`Account_id`")
    private Account account;

    public Account_Access() {
    }

    public Account_Access(Integer access_id, String permission_level, Users users, Account account) {
        this.access_id = access_id;
        this.permission_level = permission_level;
        this.users = users;
        this.account = account;
    }

    public Integer getAccess_id() {
        return access_id;
    }

    public void setAccess_id(Integer access_id) {
        this.access_id = access_id;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
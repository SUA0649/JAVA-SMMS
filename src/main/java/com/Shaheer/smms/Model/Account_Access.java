package com.Shaheer.smms.Model;

import jakarta.persistence.*;

@Entity
@Table(name="`Account Access`")
public class Account_Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Access_id;
    // User_id
    //Account_id1
    private String Permission_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="`User_id`")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="`Account_id`")
    private Account account;

    public Account_Access() {
    }

    public Account_Access(int access_id, String permission_level, Users users, Account account) {
        Access_id = access_id;
        Permission_level = permission_level;
        this.users = users;
        this.account = account;
    }

    public int getAccess_id() {
        return Access_id;
    }

    public void setAccess_id(int access_id) {
        Access_id = access_id;
    }

    public String getPermission_level() {
        return Permission_level;
    }

    public void setPermission_level(String permission_level) {
        Permission_level = permission_level;
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

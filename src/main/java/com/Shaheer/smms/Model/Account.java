package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`Account_id`")
    private int Account_id;

    private String Platform;
    private String Handle;
    private String Status;

    @JsonIgnore
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Account_Access> access;

    @JsonIgnore
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Subscriptions> subscriptions;

    @JsonIgnore
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<AssetsTracking> trackings;

    public List<Account_Access> getAccess() {
        return access;
    }

    public void setAccess(List<Account_Access> access) {
        this.access = access;
    }

    public List<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<AssetsTracking> getTrackings() {
        return trackings;
    }

    public void setTrackings(List<AssetsTracking> trackings) {
        this.trackings = trackings;
    }

    public Account(int account_id, String platform, String handle, String status, List<Account_Access> access, List<Subscriptions> subscriptions, List<AssetsTracking> trackings) {
        Account_id = account_id;
        Platform = platform;
        Handle = handle;
        Status = status;
        this.access = access;
        this.subscriptions = subscriptions;
        this.trackings = trackings;
    }

    public Account(){}



    public int getAccount_id() {
        return Account_id;
    }

    public void setAccount_id(int account_id) {
        Account_id = account_id;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public String getHandle() {
        return Handle;
    }

    public void setHandle(String handle) {
        Handle = handle;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`Account_id`")
    private Integer account_id;

    private String platform;
    private String handle;
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Account_Access> access;

    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Subscriptions> subscriptions;

    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
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

    public Account(Integer account_id, String platform, String handle, String status, List<Account_Access> access, List<Subscriptions> subscriptions, List<AssetsTracking> trackings) {
        this.account_id = account_id;
        this.platform = platform;
        this.handle = handle;
        this.status = status;
        this.access = access;
        this.subscriptions = subscriptions;
        this.trackings = trackings;
    }

    public Account() {
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


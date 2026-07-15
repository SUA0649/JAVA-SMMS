package com.Shaheer.smms.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="`Assets Tracking`")
public class AssetsTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Tracking_id;

    //Asset_id
    //Account_id
    private String URL;
    private Date Published_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Asset_id")
    private ContentAssets asset;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "Account_id")
    private Account account;

    @OneToMany(mappedBy = "tracking",cascade = CascadeType.ALL)
    private List<PerformanceMetrics> metrics;


    public AssetsTracking() {
    }

    public List<PerformanceMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<PerformanceMetrics> metrics) {
        this.metrics = metrics;
    }

    public AssetsTracking(int tracking_id, String URL, Date published_at, ContentAssets asset, Account account, List<PerformanceMetrics> metrics) {
        Tracking_id = tracking_id;
        this.URL = URL;
        Published_at = published_at;
        this.asset = asset;
        this.account = account;
        this.metrics = metrics;
    }

    public int getTracking_id() {
        return Tracking_id;
    }

    public void setTracking_id(int tracking_id) {
        Tracking_id = tracking_id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Date getPublished_at() {
        return Published_at;
    }

    public void setPublished_at(Date published_at) {
        Published_at = published_at;
    }

    public ContentAssets getAsset() {
        return asset;
    }

    public void setAsset(ContentAssets asset) {
        this.asset = asset;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

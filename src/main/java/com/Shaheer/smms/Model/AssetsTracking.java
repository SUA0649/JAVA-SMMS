package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="`Assets Tracking`")
public class AssetsTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tracking_id;

    //Asset_id
    //Account_id
    private String url;
    private Date published_at;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Asset_id")
    private ContentAssets asset;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "Account_id")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "tracking",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PerformanceMetrics> metrics;


    public AssetsTracking() {
    }

    public List<PerformanceMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<PerformanceMetrics> metrics) {
        this.metrics = metrics;
    }

    public Integer getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(Integer tracking_id) {
        this.tracking_id = tracking_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublished_at() {
        return published_at;
    }

    public void setPublished_at(Date published_at) {
        this.published_at = published_at;
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

    public AssetsTracking(Integer tracking_id, String url, Date published_at, ContentAssets asset, Account account, List<PerformanceMetrics> metrics) {
        this.tracking_id = tracking_id;
        this.url = url;
        this.published_at = published_at;
        this.asset = asset;
        this.account = account;
        this.metrics = metrics;
    }
}

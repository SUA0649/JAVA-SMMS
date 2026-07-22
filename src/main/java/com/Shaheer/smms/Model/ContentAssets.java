package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "`Content Assets`")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContentAssets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asset_id;
    // Campaign_id
    private String title;
    private String format;
    @Column(name="`Internal Status`")
    private String internalStatus;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "Campaign_id")
    private Campaign campaign;

    @JsonIgnore
    @OneToMany(mappedBy = "asset",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AssetsTracking> trackingList;

    public ContentAssets() {
    }

    public Integer getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(Integer asset_id) {
        this.asset_id = asset_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getInternalStatus() {
        return internalStatus;
    }

    public void setInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public List<AssetsTracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<AssetsTracking> trackingList) {
        this.trackingList = trackingList;
    }

    public ContentAssets(Integer asset_id, String title, String format, String internalStatus, Campaign campaign, List<AssetsTracking> trackingList) {
        this.asset_id = asset_id;
        this.title = title;
        this.format = format;
        this.internalStatus = internalStatus;
        this.campaign = campaign;
        this.trackingList = trackingList;
    }
}

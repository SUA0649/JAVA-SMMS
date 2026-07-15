package com.Shaheer.smms.Model;

import com.Shaheer.smms.Model.Campaign;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "`Content Assets`")
public class ContentAssets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Asset_id;
    // Campaign_id
    private String Title;
    private String Format;
    @Column(name="`Internal Status`")
    private String InternalStatus;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "Campaign_id")
    private Campaign campaign;

    public int getAsset_id() {
        return Asset_id;
    }

    public void setAsset_id(int asset_id) {
        Asset_id = asset_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getInternalStatus() {
        return InternalStatus;
    }

    public void setInternalStatus(String internalStatus) {
        InternalStatus = internalStatus;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public ContentAssets() {
    }

    public ContentAssets(int asset_id, String title, String format, String internalStatus, Campaign campaign) {
        Asset_id = asset_id;
        Title = title;
        Format = format;
        InternalStatus = internalStatus;
        this.campaign = campaign;
    }
}

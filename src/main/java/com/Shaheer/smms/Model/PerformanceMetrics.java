package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="`Performance Metrics`")
public class PerformanceMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int metric_id;
    // Tracking_id
    private Date date_recorded;
    private double views;
    private double likes;
    private double shares;
    private double revenue_generated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tracking_id")
    private AssetsTracking tracking;

    public PerformanceMetrics() {

    }

    public int getMetric_id() {
        return metric_id;
    }

    public void setMetric_id(int metric_id) {
        this.metric_id = metric_id;
    }

    public Date getDate_recorded() {
        return date_recorded;
    }

    public void setDate_recorded(Date date_recorded) {
        this.date_recorded = date_recorded;
    }

    public double getViews() {
        return views;
    }

    public void setViews(double views) {
        this.views = views;
    }

    public double getLikes() {
        return likes;
    }

    public void setLikes(double likes) {
        this.likes = likes;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

    public double getRevenue_generated() {
        return revenue_generated;
    }

    public void setRevenue_generated(double revenue_generated) {
        this.revenue_generated = revenue_generated;
    }

    public AssetsTracking getTracking() {
        return tracking;
    }

    public void setTracking(AssetsTracking tracking) {
        this.tracking = tracking;
    }

    public PerformanceMetrics(int metric_id, Date date_recorded, double views, double likes, double shares, double revenue_generated, AssetsTracking tracking) {
        this.metric_id = metric_id;
        this.date_recorded = date_recorded;
        this.views = views;
        this.likes = likes;
        this.shares = shares;
        this.revenue_generated = revenue_generated;
        this.tracking = tracking;
    }
}
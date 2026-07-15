package com.Shaheer.smms.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="`Performance Metrics`")
public class PerformanceMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Metric_id;
    // Tracking_id
    private Date Date_recorded;
    private double Views;
    private double Likes;
    private double Shares;
    private double Revenue_generated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tracking_id")
    private AssetsTracking tracking;

    public PerformanceMetrics() {

    }

    public int getMetric_id() {
        return Metric_id;
    }

    public void setMetric_id(int metric_id) {
        Metric_id = metric_id;
    }

    public Date getDate_recorded() {
        return Date_recorded;
    }

    public void setDate_recorded(Date date_recorded) {
        Date_recorded = date_recorded;
    }

    public double getViews() {
        return Views;
    }

    public void setViews(double views) {
        Views = views;
    }

    public double getLikes() {
        return Likes;
    }

    public void setLikes(double likes) {
        Likes = likes;
    }

    public double getShares() {
        return Shares;
    }

    public void setShares(double shares) {
        Shares = shares;
    }

    public double getRevenue_generated() {
        return Revenue_generated;
    }

    public void setRevenue_generated(double revenue_generated) {
        Revenue_generated = revenue_generated;
    }

    public AssetsTracking getTracking() {
        return tracking;
    }

    public void setTracking(AssetsTracking tracking) {
        this.tracking = tracking;
    }

    public PerformanceMetrics(int metric_id, Date date_recorded, double views, double likes, double shares, double revenue_generated, AssetsTracking tracking) {
        Metric_id = metric_id;
        Date_recorded = date_recorded;
        Views = views;
        Likes = likes;
        Shares = shares;
        Revenue_generated = revenue_generated;
        this.tracking = tracking;
    }
}
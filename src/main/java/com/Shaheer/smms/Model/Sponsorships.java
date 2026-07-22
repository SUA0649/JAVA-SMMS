package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sponsorships {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer s_id;

    private String name;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private double budget;
    @Enumerated(EnumType.STRING)
    private Types type;

    @OneToMany(mappedBy = "referral_id",cascade = CascadeType.ALL)
    private List<Invoices> invoices;

    @ManyToMany(mappedBy="sponsorships")
    private List<Campaign> campaigns = new ArrayList<>();

    public enum Types{
        YEARLY,
        MONTHLY,
        ONETIME
    }

    public Sponsorships() {
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public List<Invoices> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoices> invoices) {
        this.invoices = invoices;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public Sponsorships(Integer s_id, String name, LocalDateTime start_date, LocalDateTime end_date, double budget, Types type, List<Invoices> invoices, List<Campaign> campaigns) {
        this.s_id = s_id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.budget = budget;
        this.type = type;
        this.invoices = invoices;
        this.campaigns = campaigns;
    }
}

package com.Shaheer.smms.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sponsorships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int S_id;

    private String Name;
    private Date Start_date;
    private Date End_date;
    private double Budget;
    @Enumerated(EnumType.STRING)
    private Types Type;


    @OneToMany(mappedBy = "Referal_id",cascade = CascadeType.ALL)
    private List<Invoices> invoices;

    @ManyToMany
    @JoinTable(name="Campaign_Sponsorships"
            ,joinColumns = @JoinColumn(name="Sponsor_id"),
            inverseJoinColumns = @JoinColumn(name="Campaign_id"))
    private List<Campaign> sharedAssets = new ArrayList<>();

    public enum Types{
        YEARLY,
        MONTHLY,
        ONETIME
    }

    public Sponsorships() {
    }

    public Sponsorships(int s_id, String name, Date start_date, Date end_date, double budget, Types type) {
        S_id = s_id;
        Name = name;
        Start_date = start_date;
        End_date = end_date;
        Budget = budget;
        Type = type;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date start_date) {
        Start_date = start_date;
    }

    public Date getEnd_date() {
        return End_date;
    }

    public void setEnd_date(Date end_date) {
        End_date = end_date;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double budget) {
        Budget = budget;
    }

    public Types getType() {
        return Type;
    }

    public void setType(Types type) {
        Type = type;
    }
    public List<Invoices> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoices> invoices) {
        this.invoices = invoices;
    }

    public List<Campaign> getCampaigns() {
        return sharedAssets;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.sharedAssets = campaigns;
    }
}

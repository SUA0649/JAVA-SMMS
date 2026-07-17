package com.Shaheer.smms.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int C_id;

    private String Name;
    private Date Start_date;
    private Date End_date;
    private double Budget;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="Campaign_Sponsorships",
            joinColumns = @JoinColumn(name="Campaign_id"),
            inverseJoinColumns = @JoinColumn(name="Sponsor_id"))
    private List<Sponsorships> sponsorships = new ArrayList<>();

    public Campaign() {
    }

    @JsonIgnore
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<ContentAssets>   Assets;

    public List<ContentAssets> getAssets() {
        return Assets;
    }

    public void setAssets(List<ContentAssets> assets) {
        Assets = assets;
    }

    public List<Sponsorships> getSponsorships() {
        return sponsorships;
    }

    public void setSponsorships(List<Sponsorships> sponsorships) {
        this.sponsorships = sponsorships;
    }

    public Campaign(int c_id, String name, Date start_date, Date end_date, double budget) {
        C_id = c_id;
        Name = name;
        Start_date = start_date;
        End_date = end_date;
        Budget = budget;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
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
}

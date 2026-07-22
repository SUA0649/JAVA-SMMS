package com.Shaheer.smms.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer c_id;

    private String name;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private double budget;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="Campaign_Sponsorships",
            joinColumns = @JoinColumn(name="Campaign_id"),
            inverseJoinColumns = @JoinColumn(name="Sponsor_id"))
    private List<Sponsorships> sponsorships = new ArrayList<>();

    public Campaign() {
    }

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<ContentAssets>   assets;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
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

    public List<Sponsorships> getSponsorships() {
        return sponsorships;
    }

    public void setSponsorships(List<Sponsorships> sponsorships) {
        this.sponsorships = sponsorships;
    }

    public List<ContentAssets> getAssets() {
        return assets;
    }

    public void setAssets(List<ContentAssets> assets) {
        this.assets = assets;
    }

    public Campaign(Integer c_id, String name, LocalDateTime start_date, LocalDateTime end_date, double budget, List<Sponsorships> sponsorships, List<ContentAssets> assets) {
        this.c_id = c_id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.budget = budget;
        this.sponsorships = sponsorships;
        this.assets = assets;
    }
}

package com.Shaheer.smms.Dto;

import com.Shaheer.smms.Model.Sponsorships.Types;

public class SponsorshipUpdateDTO {
    private String name;
    private double budget;
    private Types type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

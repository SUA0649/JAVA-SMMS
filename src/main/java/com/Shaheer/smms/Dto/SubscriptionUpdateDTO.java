package com.Shaheer.smms.Dto;

import java.time.LocalDateTime;

public class SubscriptionUpdateDTO {
    private Double cost;
    private LocalDateTime due_date;

    public Double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }
}

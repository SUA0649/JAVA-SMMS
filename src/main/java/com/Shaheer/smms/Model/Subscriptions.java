package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Subscription_id")
    private Integer subscription_id;

    // Account_id
    private LocalDateTime start_date;
    private double cost;
    private LocalDateTime due_date;
    private String title;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Replaces @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_id")
    private Account account;

    public Subscriptions() {
    }

    public Subscriptions(Integer subscription_id, LocalDateTime start_date, double cost, LocalDateTime due_date, String title, Account account) {
        this.subscription_id = subscription_id;
        this.start_date = start_date;
        this.cost = cost;
        this.due_date = due_date;
        this.title = title;
        this.account = account;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(Integer subscription_id) {
        this.subscription_id = subscription_id;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public double getCost() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

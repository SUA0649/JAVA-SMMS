package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Subscription_id;

    // Account_id
    private Date Start_date;
    private double cost;
    private Date Due_date;
    private String Title;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_id")
    private Account account;

    public Subscriptions() {
    }

    public Subscriptions(int subscription_id, Date start_date, double cost, Date due_date, String title, Account account) {
        Subscription_id = subscription_id;
        Start_date = start_date;
        this.cost = cost;
        Due_date = due_date;
        Title = title;
        this.account = account;
    }

    public int getSubscription_id() {
        return Subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        Subscription_id = subscription_id;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date start_date) {
        Start_date = start_date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDue_date() {
        return Due_date;
    }

    public void setDue_date(Date due_date) {
        Due_date = due_date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


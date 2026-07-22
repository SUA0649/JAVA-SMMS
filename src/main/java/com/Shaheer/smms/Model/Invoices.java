package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoice_id;
    @Enumerated(EnumType.STRING)
    private Types type;
    private double amount;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime due_date;
    public enum Types{
        Credit,
        Debit
    }

    //Foreign-Key
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Referal_id")
    private Sponsorships referral_id;

    public Invoices() {
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public Sponsorships getReferral_id() {
        return referral_id;
    }

    public void setReferral_id(Sponsorships referral_id) {
        this.referral_id = referral_id;
    }

    public Invoices(Integer invoice_id, Types type, double amount, String status, LocalDateTime created_at, LocalDateTime due_date, Sponsorships referral_id) {
        this.invoice_id = invoice_id;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.created_at = created_at;
        this.due_date = due_date;
        this.referral_id = referral_id;
    }
}

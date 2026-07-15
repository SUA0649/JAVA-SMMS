package com.Shaheer.smms.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Invoice_id;
    @Enumerated(EnumType.STRING)
    private Types Type;
    private double Amount;
    private String Status;
    private Date Created_at;
    private Date Due_date;
    public enum Types{
        Credit,
        Debit
    }

    //Foreign-Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Referal_id")
    private Sponsorships Referal_id;

    public Invoices() {
    }

    public Invoices(int invoice_id, Types type, double amount, String status, Date created_at, Date due_date, Sponsorships referal_id) {
        Invoice_id = invoice_id;
        Type = type;
        Amount = amount;
        Status = status;
        Created_at = created_at;
        Due_date = due_date;
        Referal_id = referal_id;
    }

    public int getInvoice_id() {
        return Invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        Invoice_id = invoice_id;
    }

    public Types getType() {
        return Type;
    }

    public void setType(Types type) {
        Type = type;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }

    public Date getDue_date() {
        return Due_date;
    }

    public void setDue_date(Date due_date) {
        Due_date = due_date;
    }

    public Sponsorships getReferal_id() {
        return Referal_id;
    }

    public void setReferal_id(Sponsorships referal_id) {
        Referal_id = referal_id;
    }
}

package com.Shaheer.smms.Model;

import jakarta.persistence.*;

import java.util.AbstractList;
import java.util.Date;

@Entity
public class Equipment_Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Tracking_id;

    // user_id
    // Equipment_id
    private Date Date_checkout;
    private Date Date_returned;
    private String Notes;

    public Equipment_Tracking() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Equipment_id")
    private Equipment equipment;

    public Equipment_Tracking(int tracking_id, Date date_checkout, Date date_returned, String notes, Users user, Equipment equipment) {
        Tracking_id = tracking_id;
        Date_checkout = date_checkout;
        Date_returned = date_returned;
        Notes = notes;
        this.user = user;
        this.equipment = equipment;
    }

    public int getTracking_id() {
        return Tracking_id;
    }

    public void setTracking_id(int tracking_id) {
        Tracking_id = tracking_id;
    }

    public Date getDate_checkout() {
        return Date_checkout;
    }

    public void setDate_checkout(Date date_checkout) {
        Date_checkout = date_checkout;
    }

    public Date getDate_returned() {
        return Date_returned;
    }

    public void setDate_returned(Date date_returned) {
        Date_returned = date_returned;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

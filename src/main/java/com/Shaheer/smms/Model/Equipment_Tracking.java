package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.Date;

@Entity
public class Equipment_Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tracking_id;

    // user_id
    // Equipment_id
    private LocalDateTime date_checkout;
    private LocalDateTime date_returned;
    private String notes;

    public Equipment_Tracking() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Equipment_id")
    private Equipment equipment;

    public Equipment_Tracking(Integer tracking_id, LocalDateTime date_checkout, LocalDateTime date_returned, String notes, Users user, Equipment equipment) {
        this.tracking_id = tracking_id;
        this.date_checkout = date_checkout;
        this.date_returned = date_returned;
        this.notes = notes;
        this.user = user;
        this.equipment = equipment;
    }

    public Integer getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(Integer tracking_id) {
        this.tracking_id = tracking_id;
    }

    public LocalDateTime getDate_checkout() {
        return date_checkout;
    }

    public void setDate_checkout(LocalDateTime date_checkout) {
        this.date_checkout = date_checkout;
    }

    public LocalDateTime getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(LocalDateTime date_returned) {
        this.date_returned = date_returned;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

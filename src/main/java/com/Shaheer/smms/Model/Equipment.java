package com.Shaheer.smms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer equipment_id ;

    private String name;
    private String category;
    @Column(name = "`Condition`")
    private String condition;

    @JsonIgnore
    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL)
    private List<Equipment_Tracking> tracking;

    public Equipment() {
    }

    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<Equipment_Tracking> getTracking() {
        return tracking;
    }

    public void setTracking(List<Equipment_Tracking> tracking) {
        this.tracking = tracking;
    }

    public Equipment(Integer equipment_id, String name, String category, String condition, List<Equipment_Tracking> tracking) {
        this.equipment_id = equipment_id;
        this.name = name;
        this.category = category;
        this.condition = condition;
        this.tracking = tracking;
    }
}

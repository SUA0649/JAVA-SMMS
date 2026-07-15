package com.Shaheer.smms.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Equipment_id ;

    private String Name;
    private String Category;
    @Column(name = "`Condition`")
    private String Condition;

    @OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL)
    private List<Equipment_Tracking> Tracking;

    public List<Equipment_Tracking> getTracking() {
        return Tracking;
    }

    public void setTracking(List<Equipment_Tracking> tracking) {
        Tracking = tracking;
    }

    public Equipment(int equipment_id, String name, String category, String condition, List<Equipment_Tracking> tracking) {
        Equipment_id = equipment_id;
        Name = name;
        Category = category;
        Condition = condition;
        Tracking = tracking;
    }

    public Equipment(){}

    public int getEquipment_id() {
        return Equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        Equipment_id = equipment_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }
}

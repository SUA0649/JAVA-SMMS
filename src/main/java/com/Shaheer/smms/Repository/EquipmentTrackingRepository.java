package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Equipment;
import com.Shaheer.smms.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Shaheer.smms.Model.Equipment_Tracking;

import java.util.List;

public interface EquipmentTrackingRepository extends JpaRepository<Equipment_Tracking,Integer> {
    public List<Equipment_Tracking> findByUser(Users user);
    public List<Equipment_Tracking> findByEquipment(Equipment equipment);
}

package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.Equipment;
import com.Shaheer.smms.Model.Equipment_Tracking;
import com.Shaheer.smms.Model.Users;
import com.Shaheer.smms.Repository.EquipmentRepository;
import com.Shaheer.smms.Repository.EquipmentTrackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final EquipmentRepository repo;
    private final EquipmentTrackingRepository t_repo;

    public InventoryService(EquipmentRepository repo, EquipmentTrackingRepository t_repo) {
        this.repo = repo;
        this.t_repo = t_repo;
    }

    public List<Equipment> getAllEquipment(){
        return this.repo.findAll();
    }

    public Equipment getEquipmentById(int id){
        return this.repo.findById(id).orElseThrow();
    }

    public List<Users> getUsersByEquipmentid(int id){
        Equipment equipment = this.repo.findById(id).orElseThrow();

        List<Equipment_Tracking> equipmentTrackings = t_repo.findByEquipment(equipment);

        return equipmentTrackings.stream().map(Equipment_Tracking::getUser).toList();
    }
}

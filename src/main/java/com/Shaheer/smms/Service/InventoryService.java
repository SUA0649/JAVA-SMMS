package com.Shaheer.smms.Service;

import com.Shaheer.smms.Dto.EquipmentTrackingUpdateDTO;
import com.Shaheer.smms.Dto.EquipmentUpdateDTO;
import com.Shaheer.smms.Model.Equipment;
import com.Shaheer.smms.Model.Equipment_Tracking;
import com.Shaheer.smms.Model.Users;
import com.Shaheer.smms.Repository.EquipmentRepository;
import com.Shaheer.smms.Repository.EquipmentTrackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Users> getUsersByEquipment(int id){
        Equipment equipment = this.repo.findById(id).orElseThrow();

        List<Equipment_Tracking> equipmentTrackings = t_repo.findByEquipment(equipment);

        return equipmentTrackings.stream().map(Equipment_Tracking::getUser).toList();
    }

    public boolean deleteEquipmentById(Integer id){
        if(this.repo.existsById(id)){
            this.repo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteEquipmentTrackingById(Integer id){
        if(this.t_repo.existsById(id)){
            this.t_repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Equipment createNewEquipment(Equipment equipment){
        return this.repo.save(equipment);
    }

    public Equipment_Tracking createNewEquipmentsTracking(Equipment_Tracking tracking){
        return this.t_repo.save(tracking);
    }

    public Equipment updateEquipment(Integer id, EquipmentUpdateDTO updateDTO){
        Equipment existingEquipment = this.repo.findById(id).orElseThrow();

        if(updateDTO.getCategory()!=null)
            existingEquipment.setCategory(updateDTO.getCategory());

        if(updateDTO.getName()!=null)
            existingEquipment.setName(updateDTO.getName());

        if(updateDTO.getCondition()!=null)
            existingEquipment.setCondition(updateDTO.getCondition());

        return existingEquipment;
    }

    public Equipment_Tracking updateEquipmentTracking(Integer id, EquipmentTrackingUpdateDTO updateDTO){
        Equipment_Tracking existingTracking = this.t_repo.findById(id).orElseThrow();

        if(updateDTO.getDate_returned()!=null)
            existingTracking.setDate_returned(updateDTO.getDate_returned());

        return existingTracking;
    }
}

package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Equipment;
import com.Shaheer.smms.Model.Equipment_Tracking;
import com.Shaheer.smms.Model.Users;
import com.Shaheer.smms.Service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/equipment")
    public List<Equipment> getAllEquipment(){
        return this.service.getAllEquipment();
    }

    @GetMapping("/equipment/{id}")
    public Equipment getEquipmentById(@PathVariable int id){
        return this.service.getEquipmentById(id);
    }

    @GetMapping("/equipment/{id}/users")
    public List<Users> getUserByEquipmentId(@PathVariable int id){
        return service.getUsersByEquipment(id);
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<String> deleteEquipmentById(@PathVariable Integer id){
        if(this.service.deleteEquipmentById(id)){
            return ResponseEntity.ok("Equipment deleted successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: There was an error deleting the equipment.");
        }
    }

    @DeleteMapping("/equipment/tracking/{id}")
    public ResponseEntity<String> deleteEquipmentTrackingById(@PathVariable Integer id){
        if(this.service.deleteEquipmentTrackingById(id)){
            return ResponseEntity.ok("Equipment Tracking deleted Successfully!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Couldn't delete tracking id due to some error.");
        }
    }

    @PostMapping("/equipment")
    public Equipment createNewEquipment(@RequestBody Equipment equipment){
        return this.service.createNewEquipment(equipment);
    }

    @PostMapping("/equipment/tracking")
    public Equipment_Tracking createNewEquipmentTracking(@RequestBody Equipment_Tracking tracking){
        return this.service.createNewEquipmentsTracking(tracking);
    }
}

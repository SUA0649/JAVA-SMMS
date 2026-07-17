package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Equipment;
import com.Shaheer.smms.Model.Users;
import com.Shaheer.smms.Service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return service.getUsersByEquipmentid(id);
    }
}

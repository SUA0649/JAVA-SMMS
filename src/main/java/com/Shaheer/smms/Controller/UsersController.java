package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Account;
import com.Shaheer.smms.Model.Equipment;
import com.Shaheer.smms.Model.Users;
import com.Shaheer.smms.Service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @GetMapping("/users/{id}/accounts")
    public List<Account> getAccountByUserId(@PathVariable int id){
        return service.getAccountsbyUserId(id);
    }

    @GetMapping("/users/{id}/equipment")
    public List<Equipment> getEquipmentebyUserId(@PathVariable int id) {
        return service.getEquipmentebyUserId(id);
    }
    }

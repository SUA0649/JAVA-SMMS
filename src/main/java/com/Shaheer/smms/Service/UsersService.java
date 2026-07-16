package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.*;
import com.Shaheer.smms.Repository.Account_AccessRepository;
import com.Shaheer.smms.Repository.EquipmentTrackingRepository;
import com.Shaheer.smms.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository u_repo;
    private final Account_AccessRepository a_repo;
    private final EquipmentTrackingRepository e_repo;

    public UsersService(UsersRepository u_repo, Account_AccessRepository a_repo, EquipmentTrackingRepository e_repo) {
        this.u_repo = u_repo;
        this.a_repo = a_repo;
        this.e_repo = e_repo;
    }

    public List<Users> getAllUsers(){
        return u_repo.findAll();
    }
    
    public Optional<Users> getUserById(int id){
        return u_repo.findById(id);
    }

    public List<Account> getAccountsbyUserId(int id){
        Users user = u_repo.findById(id).orElseThrow();
        List<Account_Access>  accessList = a_repo.findByUsers(user);

        return accessList.stream().map(Account_Access::getAccount).toList();

    }

    public List<Equipment> getEquipmentebyUserId(int id){
        Users user = u_repo.findById(id).orElseThrow();
        List<Equipment_Tracking> trackList = e_repo.findByUser(user);

        return trackList.stream().map(Equipment_Tracking::getEquipment).toList();
    }
}

package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.*;
import com.Shaheer.smms.Service.AccountService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return service.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccountById(@PathVariable int id){
        return service.getAccountById(id);
    }

    @GetMapping("/accounts/{id}/users")
    public List<Users> getUsersByAccountId(@PathVariable int id){
        return service.getUsersByAccountId(id);
    }

    @GetMapping("/accounts/{id}/assets")
    public List<ContentAssets> getAssetsByAccountId(@PathVariable int id){
        return service.getAssetsByAccountId(id);
    }

    @GetMapping("/accounts/{id}/subscriptions")
    public List<Subscriptions> getSubscriptionsByAccountId(@PathVariable int id){
        return service.getSubscriptionsByAccountId(id);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createNewAccount(@RequestBody Account account){
        return new ResponseEntity<>(service.createNewAccount(account),HttpStatus.OK);
    }

    @PostMapping("/accounts/access")
    public ResponseEntity<Account_Access> createNewUserAccess(@RequestBody Account_Access access){
        return new ResponseEntity<>(service.createNewUserAccess(access),HttpStatus.OK);
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscriptions> createNewSubscription(@RequestBody Subscriptions subscription){
        return new ResponseEntity<>(service.createNewSubscription(subscription),HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Integer id){
        this.service.deleteAccount(id);
    }

    @DeleteMapping("/accounts/access/{id}")
    public void deleteAccess(@PathVariable Integer id){
        this.service.deleteAccess(id);
    }

    @DeleteMapping("/subscriptions/{id}")
    public void deleteSubscriptions(@PathVariable Integer id){
        this.service.deleteSubscription(id);
    }

}

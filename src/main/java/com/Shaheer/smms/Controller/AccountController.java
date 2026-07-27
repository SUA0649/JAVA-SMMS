package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Dto.AccountAccessUpdateDTO;
import com.Shaheer.smms.Dto.AccountUpdateDTO;
import com.Shaheer.smms.Dto.SubscriptionUpdateDTO;
import com.Shaheer.smms.Model.*;
import com.Shaheer.smms.Service.AccountService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@PreAuthorize("hasAnyRole('USER','ADMIN','VIEWER','MANAGER')")
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

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/accounts")
    public ResponseEntity<Account> createNewAccount(@RequestBody Account account){
        return new ResponseEntity<>(service.createNewAccount(account),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/accounts/access")
    public ResponseEntity<Account_Access> createNewUserAccess(@RequestBody Account_Access access){
        return new ResponseEntity<>(service.createNewUserAccess(access),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/subscriptions")
    public ResponseEntity<Subscriptions> createNewSubscription(@RequestBody Subscriptions subscription){
        return new ResponseEntity<>(service.createNewSubscription(subscription),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Integer id){
        this.service.deleteAccount(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/accounts/access/{id}")
    public void deleteAccess(@PathVariable Integer id){
        this.service.deleteAccess(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/subscriptions/{id}")
    public void deleteSubscriptions(@PathVariable Integer id){
        this.service.deleteSubscription(id);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable Integer id, @RequestBody AccountUpdateDTO account){
        return this.service.updateAccount(id,account);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PutMapping("/accounts/access/{id}")
    public Account_Access updateAccountAccess(@PathVariable Integer id, @RequestBody AccountAccessUpdateDTO access){
        return this.service.updateAccess(id,access);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN','MANAGER')")
    @PutMapping("/subscriptions/{id}")
    public Subscriptions updateSubscriptions(@PathVariable Integer id, @RequestBody SubscriptionUpdateDTO subscription){
        return this.service.updateSubscriptions(id,subscription);
    }
}

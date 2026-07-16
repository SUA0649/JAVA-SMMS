package com.Shaheer.smms.Controller;

import com.Shaheer.smms.Model.Account;
import com.Shaheer.smms.Model.ContentAssets;
import com.Shaheer.smms.Model.Subscriptions;
import com.Shaheer.smms.Model.Users;
import com.Shaheer.smms.Service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

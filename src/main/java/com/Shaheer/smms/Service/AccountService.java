package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.*;
import com.Shaheer.smms.Repository.AccountRepository;
import com.Shaheer.smms.Repository.Account_AccessRepository;
import com.Shaheer.smms.Repository.AssetsTrackingRepository;
import com.Shaheer.smms.Repository.SubscriptionsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repo;
    private final Account_AccessRepository a_repo;
    private final AssetsTrackingRepository t_repo;
    private final SubscriptionsRepository s_repo;

    public AccountService(AccountRepository repo, Account_AccessRepository a_repo, AssetsTrackingRepository t_repo, SubscriptionsRepository s_repo) {
        this.repo = repo;
        this.a_repo = a_repo;
        this.t_repo = t_repo;
        this.s_repo = s_repo;
    }

    public List<Account> getAllAccounts()
    {
        return this.repo.findAll();
    }

    public Optional<Account> getAccountById(int id){
        return this.repo.findById(id);
    }

    public List<Users> getUsersByAccountId(int id){
        Account account = this.repo.findById(id).orElseThrow();

        List<Account_Access> accessList = a_repo.findByAccount(account);

        return accessList.stream().map(Account_Access::getUsers).toList();
    }

    public List<ContentAssets> getAssetsByAccountId(int id){
        Account account = this.repo.findById(id).orElseThrow();

        List<AssetsTracking> trackingList = this.t_repo.findByAccount(account);

        return trackingList.stream().map(AssetsTracking::getAsset).toList();
    }

    public List<Subscriptions> getSubscriptionsByAccountId(int id){
        Account account = this.repo.findById(id).orElseThrow();
        return this.s_repo.findByAccount(account);
    }
    public Account createNewAccount(Account account){
            return this.repo.save(account);
    }

    public Account_Access createNewUserAccess(Account_Access access){
        return this.a_repo.save(access);
    }

    public Subscriptions createNewSubscription(Subscriptions subscriptions){
        return this.s_repo.save(subscriptions);
    }

    public void deleteAccount(Integer account_id){
         this.repo.deleteById(account_id);
    }

    public void deleteAccess(Integer access_id){
        this.a_repo.deleteById(access_id);
    }

    public void deleteSubscription(Integer subscription_id){
        this.s_repo.deleteById(subscription_id);
    }

}

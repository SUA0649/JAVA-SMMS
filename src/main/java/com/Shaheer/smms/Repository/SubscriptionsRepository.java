package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Account;
import com.Shaheer.smms.Model.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions,Integer> {
    List<Subscriptions> findByAccount(Account account);
}

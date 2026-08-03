package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Account;
import com.Shaheer.smms.Model.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscriptions,Integer> {
    List<Subscriptions> findByAccount(Account account);
}

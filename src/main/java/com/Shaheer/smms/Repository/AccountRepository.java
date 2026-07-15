package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}

package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Account;
import com.Shaheer.smms.Model.Account_Access;
import com.Shaheer.smms.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Account_AccessRepository extends JpaRepository<Account_Access,Integer> {
    List<Account_Access> findByUsers(Users users);
    List<Account_Access> findByAccount(Account account);
}

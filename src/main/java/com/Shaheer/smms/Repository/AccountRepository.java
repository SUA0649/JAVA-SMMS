package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
}

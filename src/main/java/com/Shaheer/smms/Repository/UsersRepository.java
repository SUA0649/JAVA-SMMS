package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{
}

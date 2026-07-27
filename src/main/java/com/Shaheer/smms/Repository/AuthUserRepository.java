package com.Shaheer.smms.Repository;

import com.Shaheer.smms.Model.AuthUser;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
    AuthUser findByEmail(String email);
}

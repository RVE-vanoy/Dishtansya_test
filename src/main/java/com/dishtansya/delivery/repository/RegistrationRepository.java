package com.dishtansya.delivery.repository;

import com.dishtansya.delivery.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository <Users, Integer>{

    boolean existsByEmail(String email);

    Optional<Users> findByEmail(String email);
}

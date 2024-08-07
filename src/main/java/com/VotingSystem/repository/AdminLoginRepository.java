package com.VotingSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.VotingSystem.entity.AdminLogin;

public interface AdminLoginRepository extends JpaRepository<AdminLogin, Integer> {
   
}
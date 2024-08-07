package com.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.VotingSystem.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {
    
	  Voter findByUsername(String username);
}

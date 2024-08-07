package com.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.VotingSystem.entity.VoterLogin;
@Repository
public interface VoteLoginRepository extends JpaRepository<VoterLogin, Long> {

	
}

package com.VotingSystem.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VotingSystem.entity.Election;

public interface ElectionRepo extends JpaRepository<Election, Long> {
	 
	    List<Election> findByStartDateAfter(Date date);
	}


package com.VotingSystem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Voter;
import com.VotingSystem.entity.VoterLogin;
import com.VotingSystem.repository.VoteLoginRepository;
import com.VotingSystem.repository.VoterRepository;


@Service
public class VoterLoginService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private VoteLoginRepository  voterLoginRecordRepository;

    public Voter getVoterByUsername(String username) {
        return voterRepository.findByUsername(username);
    }

    public void saveVoterLoginRecord(String username) {
        VoterLogin voterlogin = new VoterLogin();
        voterlogin.setUsername(username);
  
        voterlogin.setLoginTime(new Date()); 
        voterLoginRecordRepository.save(voterlogin);
    }
}



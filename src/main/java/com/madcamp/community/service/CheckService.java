package com.madcamp.community.service;

import com.madcamp.community.domain.Userauth;
import com.madcamp.community.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {
    private final UserAuthRepository userAuthRepository;

    @Autowired
    public CheckService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public Userauth findByKAISTId(int KAISTId){
        return userAuthRepository.findByKAISTId(KAISTId);
    }
}

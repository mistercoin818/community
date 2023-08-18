package com.madcamp.community.service;

import com.madcamp.community.domain.User;
import com.madcamp.community.domain.Userauth;
import com.madcamp.community.repository.UserRepository;
import com.madcamp.community.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JoinService(UserRepository userRepository, UserAuthRepository userAuthRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userAuthRepository = userAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(String userId, String password, String userName, String school, Integer studentId, Integer groupNum, String githubAcct) {
        // 비밀번호를 암호화하여 저장
        String encryptedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUserId(userId);
        user.setPassword(encryptedPassword);
        user.setUserName(userName);
        user.setSchool(school);
        user.setStudentId(studentId);
        user.setGroupNum(groupNum);
        user.setGithubAcct(githubAcct);

        userRepository.save(user);
    }

    public Userauth findByKAISTId(Integer studentId) {
        return userAuthRepository.findByKAISTId(studentId);
    }
}

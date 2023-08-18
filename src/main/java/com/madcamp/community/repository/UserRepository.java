package com.madcamp.community.repository;

import com.madcamp.community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    // 추가적인 쿼리 메서드나 기능을 선언할 수 있습니다.
}

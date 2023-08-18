package com.madcamp.community.repository;

import com.madcamp.community.domain.Userauth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<Userauth, Long> {

    Userauth findByKAISTId(int KAISTId);

    // 추가적인 쿼리 메서드나 기능을 선언할 수 있습니다.
}

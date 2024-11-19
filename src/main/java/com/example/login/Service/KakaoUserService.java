package com.example.login.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;

@Service
public class KakaoUserService {
private final UserRepository userRepository;

    public KakaoUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerKakaoUser(String kakaoId, String email, String nickname) {
        // 이미 등록된 사용자인지 확인
        Optional<User> existingUser = userRepository.findByKakaoId(kakaoId);
        if (existingUser.isPresent()) {
            return existingUser.get(); // 이미 등록된 사용자 반환
        }

        // 새로운 카카오 사용자 저장
        User user = new User();
        user.setKakaoId(kakaoId);
        user.setEmail(email);
        user.setName(nickname);
        user.setProvider("KAKAO");
        user.setStatus("ACTIVE");

        return userRepository.save(user);
    }
}

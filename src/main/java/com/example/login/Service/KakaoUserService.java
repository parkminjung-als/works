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

    public User registerUser(String platformId, String email, String name, String provider) {
        Optional<User> existingUser = userRepository.findByPlatformId(platformId);
        if (existingUser.isPresent()) {
            return existingUser.get();
        }

        User user = new User();
        user.setPlatformId(platformId); // 카카오 또는 네이버 ID 저장
        user.setEmail(email);
        user.setName(name);
        user.setProvider(provider); // KAKAO 또는 NAVER
        user.setStatus("ACTIVE");

        return userRepository.save(user);
    }
}

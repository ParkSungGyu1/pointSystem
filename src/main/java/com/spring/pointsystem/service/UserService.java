package com.spring.pointsystem.service;

import com.spring.pointsystem.domain.User;
import com.spring.pointsystem.repository.UserRepository;
import com.spring.pointsystem.requestDto.UserCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(UserCreateRequestDto userCreateRequestDto){
        User user = User.createUser(userCreateRequestDto.getUserName(),
                                    userCreateRequestDto.getUserCash(),
                                    userCreateRequestDto.getUserPoint());
        userRepository.save(user);
    }
}

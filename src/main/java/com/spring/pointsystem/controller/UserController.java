package com.spring.pointsystem.controller;

import com.spring.pointsystem.exception.ApiResponseMessage;
import com.spring.pointsystem.requestDto.UserCreateRequestDto;
import com.spring.pointsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    //유저 생성
    @PostMapping("/api/users/create")
    public ResponseEntity<ApiResponseMessage> createUser(@RequestBody UserCreateRequestDto userCreateDto){
        userService.createUser(userCreateDto);

        ApiResponseMessage message = new ApiResponseMessage("Success", "유저가 생성 되었습니다.", "", "");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //내 정보 확인
    /*   */
}

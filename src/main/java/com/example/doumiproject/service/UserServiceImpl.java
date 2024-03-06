package com.example.doumiproject.service;

import com.example.doumiproject.entity.User;
import com.example.doumiproject.repository.UserRepository;
import com.example.doumiproject.responsedto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(int userId) {
        User user = userRepository.selectUserById(userId);
        return new UserDto(user.getUserId(), user.getUserPassword(), user.getRole());
    }
}

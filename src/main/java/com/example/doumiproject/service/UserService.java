package com.example.doumiproject.service;

import com.example.doumiproject.entity.User;
import com.example.doumiproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {//UserService 객체 생성 시
    this.userRepository = userRepository; //UserRepository 객체 생성
  }

  /*회원 가입*/
  public void join(User user) {
    //중복 회원 검증
    validateDuplicateUser(user);

    //중복 회원이 아니면 userRepository에 저장한다
    userRepository.save(user);
  }

  /*중복 회원 검증*/
  private void validateDuplicateUser(User user) {

  }


}

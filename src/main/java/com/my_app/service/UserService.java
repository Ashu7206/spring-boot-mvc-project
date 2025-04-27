package com.my_app.service;

import com.my_app.entity.User;
import com.my_app.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        User user1=new User();
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        return userRepository.save(user1);
    }

    public Page<User> getUsers(int pageNo, int pageSize){
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        return userRepository.findAll(pageable);
    }

    
}

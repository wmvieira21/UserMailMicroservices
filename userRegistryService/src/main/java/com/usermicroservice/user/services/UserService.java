package com.usermicroservice.user.services;

import com.usermicroservice.user.domains.UserModel;
import com.usermicroservice.user.dtos.UserDTO;
import com.usermicroservice.user.producers.UserProducer;
import com.usermicroservice.user.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;


    @Transactional
    public UserModel saveUser(UserDTO userDTO) {
        var user = new UserModel();
        BeanUtils.copyProperties(userDTO, user, "userID");

        var userSaved = userRepository.save(user);
        userProducer.publishMessageEmail(user);

        return userSaved;
    }
}

package com.SpringBoot_RegisterSistem.Service;

import com.SpringBoot_RegisterSistem.DTO.LoginDTO;
import com.SpringBoot_RegisterSistem.DTO.UserDTO;
import com.SpringBoot_RegisterSistem.Entity.User;
import com.SpringBoot_RegisterSistem.Exception.UserWasRegistred;
import com.SpringBoot_RegisterSistem.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List confirmLoginUserExist(User user) {

        return() ;
    }
}

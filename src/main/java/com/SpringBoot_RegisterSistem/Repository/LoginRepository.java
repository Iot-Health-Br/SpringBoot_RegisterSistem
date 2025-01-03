package com.SpringBoot_RegisterSistem.Repository;

import com.SpringBoot_RegisterSistem.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository {
    Optional<User> findByCpf(String cpf);
    Optional<User> findByCpfAndPassword(String cpf, String password);
}

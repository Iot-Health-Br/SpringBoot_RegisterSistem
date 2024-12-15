package com.SpringBoot_RegisterSistem.Repository;

import com.SpringBoot_RegisterSistem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByName(String name);
    boolean existsByCpf(String cpf);
    boolean existsByTelefone(String telefone);
    boolean existsByEmail(String email);
}

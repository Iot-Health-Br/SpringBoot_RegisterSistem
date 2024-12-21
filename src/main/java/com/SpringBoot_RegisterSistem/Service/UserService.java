package com.SpringBoot_RegisterSistem.Service;

import com.SpringBoot_RegisterSistem.DTO.UserDTO;
import com.SpringBoot_RegisterSistem.Entity.User;
import com.SpringBoot_RegisterSistem.Exception.ConcurrencyException;
import com.SpringBoot_RegisterSistem.Exception.DataAlreadyExistsException;
import com.SpringBoot_RegisterSistem.Exception.ResourceNotFoundException;
import com.SpringBoot_RegisterSistem.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public UserDTO createUser(User user) {
        try {

            if (userRepository.existsByName(user.getName())) {
                throw new DataAlreadyExistsException("Nome já cadastrado!");
            }else if (userRepository.existsByCpf(user.getCpf())) {
                throw new DataAlreadyExistsException("CPF já cadastrado!");
            }else if (userRepository.existsByTelefone(user.getTelefone())) {
                throw new DataAlreadyExistsException("Telefone já cadastrado!");
            }else if (userRepository.existsByEmail(user.getEmail())) {
                throw new DataAlreadyExistsException("Email já cadastrado!");
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);
            return convertToDTO(savedUser);
        } catch (ObjectOptimisticLockingFailureException e) {
            // Tenta novamente ou lança uma exceção personalizada
            throw new ConcurrencyException("Erro de concorrência ao salvar usuário. Por favor, tente novamente.");
        }
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return convertToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        if (!user.getName().equals(userDetails.getName()) &&
                userRepository.existsByName(userDetails.getName())) {
            throw new DataAlreadyExistsException("Nome já está em uso");
        }else if (!user.getCpf().equals(userDetails.getCpf()) &&
                userRepository.existsByCpf(userDetails.getCpf())) {
            throw new DataAlreadyExistsException("CPF já está em uso");
        }else if (!user.getTelefone().equals(userDetails.getTelefone()) &&
                userRepository.existsByTelefone(userDetails.getTelefone())) {
            throw new DataAlreadyExistsException("Telefone já está em uso");
        }else if (!user.getEmail().equals(userDetails.getEmail()) &&
                userRepository.existsByEmail(userDetails.getEmail())) {
            throw new DataAlreadyExistsException("Email já está em uso");
        }

        // Mantém os dados originais se não for fornecido um novo
        if (user.getName() == null || userDetails.getName().isEmpty()) {
            userDetails.setName(user.getName());
        }else if (user.getCpf() == null || userDetails.getCpf().isEmpty()) {
            userDetails.setCpf(user.getCpf());
        }else if (user.getTelefone() == null || userDetails.getTelefone().isEmpty()) {
            userDetails.setTelefone(user.getTelefone());
        }else if (user.getEmail() == null || userDetails.getEmail().isEmpty()) {
            userDetails.setEmail(user.getEmail());
        }

        userDetails.setId(id);
        if (userDetails.getPassword() != null) {
            userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        User updatedUser = userRepository.save(userDetails);
        return convertToDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO, "password");
        return userDTO;
    }
}


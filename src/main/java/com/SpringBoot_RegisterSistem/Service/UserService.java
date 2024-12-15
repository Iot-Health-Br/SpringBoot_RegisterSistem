package com.SpringBoot_RegisterSistem.Service;

import com.SpringBoot_RegisterSistem.DTO.UserDTO;
import com.SpringBoot_RegisterSistem.Entity.User;
import com.SpringBoot_RegisterSistem.Exception.DataAlreadyExistsException;
import com.SpringBoot_RegisterSistem.Exception.ResourceNotFoundException;
import com.SpringBoot_RegisterSistem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserDTO createUser(User user) {
        if (userRepository.existsByName(user.getName())) {
            throw new DataAlreadyExistsException("Nome já cadastrado!");
        }else if (userRepository.existsByCpf(user.getCpf())) {
            throw new DataAlreadyExistsException("CPF já cadastrado!");
        }else if (userRepository.existsByTelefone(user.getTelefone())) {
            throw new DataAlreadyExistsException("Telefone já cadastrado!");
        }else if (userRepository.existsByEmail(user.getEmail())) {
            throw new DataAlreadyExistsException("Email já cadastrado!");
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);
            return convertToDTO(savedUser);
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

        if (!user.getEmail().equals(userDetails.getEmail()) &&
                userRepository.existsByEmail(userDetails.getEmail())) {
            throw new DataAlreadyExistsException("Email já está em uso");
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


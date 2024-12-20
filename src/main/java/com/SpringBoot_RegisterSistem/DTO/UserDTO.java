package com.SpringBoot_RegisterSistem.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String telefone;
    private String email;
    private String password;
    // Senha não incluída no DTO por segurança
}
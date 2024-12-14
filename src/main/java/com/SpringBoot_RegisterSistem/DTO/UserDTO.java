package com.SpringBoot_RegisterSistem.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    // Senha não incluída no DTO por segurança
}
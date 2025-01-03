package com.SpringBoot_RegisterSistem.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@Schema(description = "DTO de resposta com dados do usuário")
public class UserDTO {
    @Schema(description = "ID do usuário", example = "1")
    private Long id;
    @Schema(description = "Nome do usuário", example = "João Silva")
    private String name;
    @Schema(description = "CPF do usuário", example = "555.555.555-55")
    private String cpf;
    @Schema(description = "Telefone do usuário", example = "(62) 9 9820-9756)")
    private String telefone;
    @Schema(description = "Email do usuário", example = "joao.silva@email.com")
    private String email;
    @Schema(description = "Nova senha do usuário (opcional)", example = "NovaSenha@123")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Isso evita que a senha seja exposta acidentalmente nas respostas da API
    private String password;
    // Senha não incluída no DTO por segurança


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
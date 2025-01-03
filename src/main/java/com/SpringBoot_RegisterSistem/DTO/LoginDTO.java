package com.SpringBoot_RegisterSistem.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Objects;

public class LoginDTO {
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
    @Schema(description = "Permissão do usuário", example = "USER")
    private List<String> roles;
    @Schema(description = "Autenticação", example = "TRUE")
    private boolean authenticated;
    @Schema(description = "Mensagem de Autenticação", example = "Usuário Encontrado")
    private String message;

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", authenticated=" + authenticated +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return authenticated == loginDTO.authenticated && Objects.equals(id, loginDTO.id) && Objects.equals(name, loginDTO.name) && Objects.equals(cpf, loginDTO.cpf) && Objects.equals(telefone, loginDTO.telefone) && Objects.equals(email, loginDTO.email) && Objects.equals(roles, loginDTO.roles) && Objects.equals(message, loginDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, telefone, email, roles, authenticated, message);
    }
}

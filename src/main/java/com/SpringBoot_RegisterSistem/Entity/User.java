package com.SpringBoot_RegisterSistem.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "Nome não pode conter apenas espaços em branco")
    private String name;

    @CPF(message = "CPF deve ser válido")
    @NotNull(message = "CPF é obrigatório")
    @NotBlank(message = "CPF não pode conter apenas espaços em branco")
    private String cpf;

    @NotNull(message = "Telefone é obrigatório")
    @NotBlank(message = "Telefone não pode conter apenas espaços em branco")
    private String telefone;

    @Email(message = "Email deve ser válido")
    @NotNull(message = "Email é obrigatório")
    @NotBlank(message = "Email não pode conter apenas espaços em branco")
    private String email;

    @NotNull(message = "Senha é obrigatória")
    @NotBlank(message = "Senha não pode conter apenas espaços em branco")
    private String password;

    public User() {
    }

    public User(Long id, String name, String cpf, String telefone, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Version
    private Long version;
}

package com.SpringBoot_RegisterSistem.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
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
    private String password;
    // Senha não incluída no DTO por segurança
}
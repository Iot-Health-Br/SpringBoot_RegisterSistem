package com.SpringBoot_RegisterSistem.Model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
@Schema(description = "Resposta de Erro")
public class ErrorResponse {
    @Schema(description = "Data e Horário do Erro", example = "2025-01-03T19:26:21.815Z")
    private LocalDateTime timestamp;
    @Schema(description = "Código de erro", example = "404 Not Found")
    private int status;
    @Schema(description = "Mensagem de erro", example = "Usuário não encontrado")
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

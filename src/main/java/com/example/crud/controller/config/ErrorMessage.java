package com.example.crud.controller.config;

import java.time.LocalDateTime;

public record ErrorMessage(
        String code,
        String message,
        LocalDateTime timestamp,
        String description
) {
}

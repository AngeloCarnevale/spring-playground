package com.example.auth.domain.dtos;

import com.example.auth.domain.entities.user.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}

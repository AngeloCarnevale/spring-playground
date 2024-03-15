package com.example.auth.dtos;

import com.example.auth.domain.user.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}

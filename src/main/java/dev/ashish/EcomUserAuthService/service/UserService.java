package dev.ashish.EcomUserAuthService.service;

import dev.ashish.EcomUserAuthService.dto.*;

import java.util.UUID;

public interface UserService {
    UserResponseDTO login(LoginRequestDTO requestDTO);
    UserResponseDTO signUp(SignUpRequestDTO requestDTO);
    boolean validate(String token);

    boolean logout(String token);
    UserResponseDTO getById(UUID userId);
}

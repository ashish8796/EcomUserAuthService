package dev.ashish.EcomUserAuthService.service;

import dev.ashish.EcomUserAuthService.dto.RoleRequestDTO;
import dev.ashish.EcomUserAuthService.dto.RoleResponseDTO;

import java.util.UUID;

public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO requestDTO);
    RoleResponseDTO getRoleById(UUID roleId);
}

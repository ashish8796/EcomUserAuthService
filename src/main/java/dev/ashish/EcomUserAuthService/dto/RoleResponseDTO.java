package dev.ashish.EcomUserAuthService.dto;

import dev.ashish.EcomUserAuthService.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {
    private String role;
    private String description;
    private UUID roleId;

    public static RoleResponseDTO from(Role role) {
        RoleResponseDTO responseDTO = new RoleResponseDTO();

        responseDTO.setRole(role.getRole());
        responseDTO.setDescription(role.getDescription());
        responseDTO.setRoleId(role.getId());

        return  responseDTO;
    }

    @Override
    public String toString() {
        return "RoleResponseDTO{" +
                "role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}

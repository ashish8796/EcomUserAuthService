package dev.ashish.EcomUserAuthService.dto;

import dev.ashish.EcomUserAuthService.entity.Role;
import dev.ashish.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String emailId;
    private UUID id;
    private List<RoleResponseDTO> roles;

    public static UserResponseDTO from (User user) {
        if(user == null) return null;

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmailId(user.getEmail());

        List<RoleResponseDTO> roles = user.getRoles().stream().map(RoleResponseDTO::from).toList();
        responseDTO.setRoles(roles);
        return responseDTO;
    }
}

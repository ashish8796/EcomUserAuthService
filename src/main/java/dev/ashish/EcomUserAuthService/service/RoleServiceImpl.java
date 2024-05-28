package dev.ashish.EcomUserAuthService.service;

import dev.ashish.EcomUserAuthService.dto.RoleRequestDTO;
import dev.ashish.EcomUserAuthService.dto.RoleResponseDTO;
import dev.ashish.EcomUserAuthService.entity.Role;
import dev.ashish.EcomUserAuthService.exception.RoleControllerException.RoleNotFoundException;
import dev.ashish.EcomUserAuthService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleResponseDTO createRole(RoleRequestDTO requestDTO) {
        Role role = new Role();
        role.setRole(requestDTO.getName());
        role.setDescription(requestDTO.getDescription());

        return RoleResponseDTO.from(roleRepository.save(role));
    }

    @Override
    public RoleResponseDTO getRoleById(UUID roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + roleId));
        return RoleResponseDTO.from(role);
    }
}

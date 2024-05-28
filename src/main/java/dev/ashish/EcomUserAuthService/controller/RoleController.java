package dev.ashish.EcomUserAuthService.controller;

import dev.ashish.EcomUserAuthService.dto.RoleRequestDTO;
import dev.ashish.EcomUserAuthService.dto.RoleResponseDTO;
import dev.ashish.EcomUserAuthService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable("id") UUID roleId) {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }

    @PostMapping("/new")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO requestDTO) {
        return ResponseEntity.ok(roleService.createRole(requestDTO));
    }
}

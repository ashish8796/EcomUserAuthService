package dev.ashish.EcomUserAuthService.controller;

import dev.ashish.EcomUserAuthService.dto.LoginRequestDTO;
import dev.ashish.EcomUserAuthService.dto.SignUpRequestDTO;
import dev.ashish.EcomUserAuthService.dto.UserResponseDTO;
import dev.ashish.EcomUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        UserResponseDTO responseDTO = userService.login(requestDTO);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignUpRequestDTO requestDTO) {
        UserResponseDTO responseDTO = userService.signUp(requestDTO);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorisation") String authToken) {
        return ResponseEntity.ok(userService.validate(authToken));
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorisation") String authToken) {
        return ResponseEntity.ok(userService.logout(authToken));
    }
}

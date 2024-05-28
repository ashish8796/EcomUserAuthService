package dev.ashish.EcomUserAuthService.service;

import dev.ashish.EcomUserAuthService.dto.*;
import dev.ashish.EcomUserAuthService.entity.Role;
import dev.ashish.EcomUserAuthService.entity.User;
import dev.ashish.EcomUserAuthService.exception.RoleControllerException.RoleNotFoundException;
import dev.ashish.EcomUserAuthService.exception.UserControllerException.EmailNotExistException;
import dev.ashish.EcomUserAuthService.exception.UserControllerException.InvalidCredentialsException;
import dev.ashish.EcomUserAuthService.exception.UserControllerException.UserNotFoundException;
import dev.ashish.EcomUserAuthService.repository.RoleRepository;
import dev.ashish.EcomUserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO login(LoginRequestDTO requestDTO) throws EmailNotExistException, InvalidCredentialsException {
        User user = userRepository.findByEmail(requestDTO.getEmailId()).orElseThrow(
                () -> new UserNotFoundException("User not found.")
        );

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(requestDTO.getPassword(), user.getPassword())) {
            String userData = requestDTO.getEmailId() + requestDTO.getPassword() + LocalDateTime.now();
            String token = encoder.encode(userData);
            user.setToken(token);
            user = userRepository.save(user);
        } else {
            throw new InvalidCredentialsException("Email id or password doesn't match.");
        }

        return UserResponseDTO.from(user);
    }

    @Override
    public boolean logout(String token) {
        User user = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialsException("Invalid token.")
        );

        user.setToken(null);
        userRepository.save(user);

        return true;
    }

    @Override
    public UserResponseDTO signUp(SignUpRequestDTO requestDTO) throws RoleNotFoundException {
        Role role = roleRepository.findById(requestDTO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role is not found with " + requestDTO.getRoleId())
        );

        User user = new User();
        user.setName((requestDTO.getName()));
        user.setEmail((requestDTO.getEmailId()));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(requestDTO.getPassword());
        user.setPassword(hashedPassword);
        user.setRoles(List.of(role));

        user = userRepository.save(user);

        return UserResponseDTO.from(user);
    }

    @Override
    public boolean validate(String token) {
        User user = userRepository.findByToken(token).orElseThrow(() -> new InvalidCredentialsException("Token is not valid."));
        return true;
    }

    @Override
    public UserResponseDTO getById(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found.")
        );
        return UserResponseDTO.from(user);
    }
}

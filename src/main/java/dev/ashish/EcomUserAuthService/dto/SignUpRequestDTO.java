package dev.ashish.EcomUserAuthService.dto;

import dev.ashish.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SignUpRequestDTO {
    private String name;
    private String emailId;
    private String password;
    private UUID roleId;
}

package dev.ashish.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    private String token;

    @ManyToMany
    private List<Role> roles;
}

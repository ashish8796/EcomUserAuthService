package dev.ashish.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Role extends BaseModel{
    private String role;
    private String description;

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

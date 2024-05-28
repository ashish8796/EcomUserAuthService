package dev.ashish.EcomUserAuthService.exception.RoleControllerException;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String message) {
        super(message);
    }
}

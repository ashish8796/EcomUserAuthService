package dev.ashish.EcomUserAuthService.exception.UserControllerException;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}

package dev.ashish.EcomUserAuthService.exception.UserControllerException;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

package dev.ashish.EcomUserAuthService.exception.UserControllerException;

public class EmailNotExistException extends RuntimeException{
    public EmailNotExistException(String message) {
        super(message);
    }
}

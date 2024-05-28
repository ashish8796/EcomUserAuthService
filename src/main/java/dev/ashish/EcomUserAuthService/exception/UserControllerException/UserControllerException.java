package dev.ashish.EcomUserAuthService.exception.UserControllerException;

import dev.ashish.EcomUserAuthService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {
    @ExceptionHandler(EmailNotExistException.class)
    public ResponseEntity handleEmailNotExistException(EmailNotExistException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(
                ex.getMessage(), 404
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity handleInvalidPasswordException(InvalidCredentialsException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 401);

        return new ResponseEntity<>(responseDTO, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(UserNotFoundException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 404);

        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}

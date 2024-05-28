package dev.ashish.EcomUserAuthService.exception.RoleControllerException;

import dev.ashish.EcomUserAuthService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoleControllerException {
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity handleRoleNotFoundException(RoleNotFoundException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 404);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}

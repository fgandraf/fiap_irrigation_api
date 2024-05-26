package br.com.fiap.irrigationapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardException> handleNotFoundException(NotFoundException e, HttpServletRequest req) {
        String exception = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException excep = new StandardException(Instant.now(), status.value(), exception, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(excep);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardException> handleDatabaseException(DatabaseException e, HttpServletRequest req) {
        String exception = "Database error";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardException excep = new StandardException(Instant.now(), status.value(), exception, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(excep);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error) -> {errors.put(error.getField(), error.getDefaultMessage());});
        return errors;
    }

}

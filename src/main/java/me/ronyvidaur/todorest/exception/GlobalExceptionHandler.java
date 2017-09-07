package me.ronyvidaur.todorest.exception;

import me.ronyvidaur.todorest.util.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({SQLException.class, DataIntegrityViolationException.class})
    public ResponseEntity handleSQLException(HttpServletRequest request, Exception ex) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(null, false, request.getRequestURI());
        ResponseBuilder.addProperty("method", request.getMethod());
        ResponseBuilder.addProperty("exception", ex.getClass());
        logger.error("There was an Error trying to read/write to the database:: SQL Exception");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseBuilder.build());
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NoSuchElementException.class, NullPointerException.class})
    public ResponseEntity handleEmptyResultException(HttpServletRequest request, Exception ex) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(null, false, request.getRequestURI());
        ResponseBuilder.addProperty("method", request.getMethod());
        ResponseBuilder.addProperty("exception", ex.getClass());
        ResponseBuilder.addProperty("message", "Entity not Found");
        logger.error("There was an Error trying to retrieve the data");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseBuilder.build());
    }

}

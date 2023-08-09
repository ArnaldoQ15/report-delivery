package com.report.delivery.config.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionOutDTO> badRequestException(final BadRequestException exception) {
        log.error(exception.getMessage());

        return ResponseEntity.status(BAD_REQUEST).body(
                ExceptionOutDTO.builder()
                        .status(BAD_REQUEST)
                        .message(exception.getMessage())
                        .dateTime(now())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionOutDTO> handleGlobalException(final Exception exception) {
        log.error(exception.getMessage());

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                ExceptionOutDTO.builder()
                        .status(INTERNAL_SERVER_ERROR)
                        .message(exception.getMessage())
                        .dateTime(now()).build());
    }

}
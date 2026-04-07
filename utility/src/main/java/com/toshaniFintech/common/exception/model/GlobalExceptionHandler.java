package com.toshaniFintech.common.exception.model;

import com.toshaniFintech.common.dto.response.APIErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private APIErrorResponse buildResponse(String errorCode, String errorMessage, String actualMessage) {
        APIErrorResponse errorResponse = new APIErrorResponse();
        errorResponse.setErrorCode(errorCode);
        errorResponse.setErrorMessage(errorMessage);
        errorResponse.setErrorMessages(Collections.singletonList(actualMessage));
        return errorResponse;
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<APIErrorResponse> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(buildResponse("400", "Bad Request", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIErrorResponse> handleNotFound(NotFoundException ex) {
        return new ResponseEntity<>(buildResponse("404", "Not Found", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<APIErrorResponse> handleUnprocessable(UnprocessableEntityException ex) {
        return new ResponseEntity<>(buildResponse("422", "Unprocessable Entity", ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIErrorResponse> handleGeneric(Exception ex) {
        return new ResponseEntity<>(buildResponse("500", "Internal Server Error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        APIErrorResponse response = new APIErrorResponse();
        response.setErrorCode("400");
        response.setErrorMessage("Validation Failed");
        response.setErrorMessages(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
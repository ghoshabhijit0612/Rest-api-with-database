package com.restApiUsingDb.RestApiUsingDb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> exception(Exception ex){
        ApiResponse api = new ApiResponse();
        api.setMessege(ex.getMessage());
        api.setStatus(HttpStatus.BAD_GATEWAY);
       return new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
    }

}

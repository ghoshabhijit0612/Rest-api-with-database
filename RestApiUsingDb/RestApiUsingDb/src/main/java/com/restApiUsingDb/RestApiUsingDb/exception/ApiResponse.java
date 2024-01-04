package com.restApiUsingDb.RestApiUsingDb.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String messege;
    private HttpStatus status;


}

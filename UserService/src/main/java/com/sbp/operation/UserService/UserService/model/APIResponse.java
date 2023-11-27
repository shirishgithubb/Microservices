package com.sbp.operation.UserService.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    String message;
    String description;
    HttpStatus httpStatus;
}

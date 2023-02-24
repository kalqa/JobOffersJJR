package com.junioroffers.infrastructure.loginandregister.controller.error;

import org.springframework.http.HttpStatus;

public record TokenErrorResponse(String message,
                                 HttpStatus status) {
}

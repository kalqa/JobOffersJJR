package com.junioroffers.infrastructure.loginandregister.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TokenControllerErrorHandler {

    private static final String BAD_CREDENTIALS = "Bad Credentials";

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public TokenErrorResponse handleBadCredentials() {
        return new TokenErrorResponse(BAD_CREDENTIALS, HttpStatus.UNAUTHORIZED);
    }
}

package com.junioroffers.infrastructure.offer.controller.error;

import com.junioroffers.domain.offer.OfferNotFoundException;
import java.util.Collections;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
class OfferControllerErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OfferNotFoundException.class)
    @ResponseBody
    public OfferErrorResponse offerNotFound(OfferNotFoundException exception) {
        final String message = exception.getMessage();
        log.error(message);
        return new OfferErrorResponse(message, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public OfferPostErrorResponse offerDuplicate(DuplicateKeyException duplicateKeyException) {
        final String message = "Offer url already exists";
        log.error(message);
        return new OfferPostErrorResponse(Collections.singletonList(message), HttpStatus.CONFLICT);
    }
}

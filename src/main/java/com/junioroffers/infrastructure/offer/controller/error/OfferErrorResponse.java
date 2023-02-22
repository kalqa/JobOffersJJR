package com.junioroffers.infrastructure.offer.controller.error;

import org.springframework.http.HttpStatus;

public record OfferErrorResponse(
        String message,
        HttpStatus status) {
}

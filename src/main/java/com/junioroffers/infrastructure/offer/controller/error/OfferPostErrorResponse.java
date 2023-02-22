package com.junioroffers.infrastructure.offer.controller.error;

import java.util.List;
import org.springframework.http.HttpStatus;

public record OfferPostErrorResponse(List<String> messages,
                                     HttpStatus status) {
}

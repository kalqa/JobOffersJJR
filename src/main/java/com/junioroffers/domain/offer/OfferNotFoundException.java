package com.junioroffers.domain.offer;

import lombok.Getter;

@Getter
public class OfferNotFoundException extends RuntimeException {

    private final String offerId;

    public OfferNotFoundException(String offerId) {
        super(String.format("Offer with id %s not found", offerId));
        this.offerId = offerId;
    }
}

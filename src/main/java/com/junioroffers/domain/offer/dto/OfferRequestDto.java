package com.junioroffers.domain.offer.dto;

import lombok.Builder;

@Builder
public record OfferRequestDto(
        String companyName,
        String position,
        String salary,
        String offerUrl
) {
}

package com.junioroffers.domain.offer.dto;


import java.io.Serializable;
import lombok.Builder;

@Builder
public record OfferResponseDto(
        String id,
        String companyName,
        String position,
        String salary,
        String offerUrl
) implements Serializable {
}

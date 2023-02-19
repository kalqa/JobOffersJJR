package com.junioroffers.domain.offer;

import lombok.Builder;

@Builder
record Offer(
       String id,
       String companyName,
       String position,
       String salary,
       String offerUrl) {
}

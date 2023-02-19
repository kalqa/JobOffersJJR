package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponse;
import java.util.List;

public interface OfferFetchable {
    List<JobOfferResponse> fetchOffers();
}

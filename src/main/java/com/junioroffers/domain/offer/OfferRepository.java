package com.junioroffers.domain.offer;

import java.util.List;
import java.util.Optional;


public interface OfferRepository {

    boolean existsByOfferUrl(String offerUrl);

    Optional<Offer> findByOfferUrl(String offerUrl);

    List<Offer> saveAll(List<Offer> offers);

    List<Offer> findAll();

    Optional<Offer> findById(String id);

    Offer save(Offer offer);
}

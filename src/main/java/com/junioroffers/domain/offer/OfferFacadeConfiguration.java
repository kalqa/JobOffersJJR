package com.junioroffers.domain.offer;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferFacadeConfiguration {

    @Bean
    OfferFacade offerFacade(OfferFetchable offerFetchable) {
        OfferRepository repo = new OfferRepository() {
            @Override
            public boolean existsByOfferUrl(String offerUrl) {
                return false;
            }

            @Override
            public Optional<Offer> findByOfferUrl(String offerUrl) {
                return Optional.empty();
            }

            @Override
            public List<Offer> saveAll(List<Offer> offers) {
                return null;
            }

            @Override
            public List<Offer> findAll() {
                return null;
            }

            @Override
            public Optional<Offer> findById(String id) {
                return Optional.empty();
            }

            @Override
            public Offer save(Offer offer) {
                return null;
            }
        };
        OfferService offerService = new OfferService(offerFetchable, repo);
        return new OfferFacade(repo, offerService);
    }
}

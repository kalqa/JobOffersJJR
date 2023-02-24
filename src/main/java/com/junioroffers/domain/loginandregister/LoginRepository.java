package com.junioroffers.domain.loginandregister;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
}

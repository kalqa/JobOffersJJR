package com.junioroffers.domain.login;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLoginRepository implements LoginRepository {

    Map<String, User> database = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(database.get(username));
    }

    @Override
    public User save(User entity) {
        UUID id = UUID.randomUUID();
        User user = new User(
                id.toString(),
                entity.username(),
                entity.password()
        );
        database.put(user.username(), user);
        return user;
    }
}

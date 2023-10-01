package com.paulohenriquegrancieri.workshopmongo.repository;

import com.paulohenriquegrancieri.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

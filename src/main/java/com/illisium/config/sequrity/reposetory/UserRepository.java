package com.illisiumalfa.config.sequrity.reposetory;

import com.illisiumalfa.config.sequrity.entety.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByName(String name);
}

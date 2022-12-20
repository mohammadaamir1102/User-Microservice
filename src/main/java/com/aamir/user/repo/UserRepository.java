package com.aamir.user.repo;

import com.aamir.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findTop1ByUserNameOrderByCreatedOnDesc(String userName);
}

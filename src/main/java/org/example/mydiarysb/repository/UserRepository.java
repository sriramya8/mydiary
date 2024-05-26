package org.example.mydiarysb.repository;

import org.example.mydiarysb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    public User findByUsername( String username);
}

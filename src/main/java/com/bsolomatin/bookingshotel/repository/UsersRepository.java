package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    @Query(value="Select u From hotel.user u Where u.login = :login", nativeQuery = true)
    User findByUserName(@Param("login") String login);
}

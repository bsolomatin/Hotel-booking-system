package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}

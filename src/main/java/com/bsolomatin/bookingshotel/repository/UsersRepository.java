package com.bsolomatin.bookingshotel.repository;

import com.bsolomatin.bookingshotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    //@Query(value = "Select * From hotel.usr Where username = :log", nativeQuery = true)
    //User findByUsername(@Param("log") String log);

    User findByUsername(String login);
    User getOne(Long id);

    //@Query(value = "INSERT INTO hotel.user VALUES(:id, :username, :password)", nativeQuery = true)
    //void saveNewUser(@Param("id") int id, @Param("username")String username, @Param("password")String password);

}

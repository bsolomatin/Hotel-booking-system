package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUserName(String login);
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);
}

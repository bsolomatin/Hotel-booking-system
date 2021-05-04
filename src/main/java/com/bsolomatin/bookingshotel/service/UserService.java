package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.User;

import java.util.List;

public interface UserService {
    User findByUserName(String login);
    List<User> findAll();
    User saveUser(User user);
    void deleteById(Long id);
}

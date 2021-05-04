package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User findByUserName(String login) {
        return usersRepository.findByUserName(login);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);

    }
}

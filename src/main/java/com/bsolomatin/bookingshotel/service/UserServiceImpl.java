package com.bsolomatin.bookingshotel.service;


import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService, UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    //@Autowired
    //private RoleRepository roleRepository;

    @Override
    public User findByUserName(String login) {
        return usersRepository.findByUsername(login);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }


    @Override
    public void saveUser(User user) {
        usersRepository.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);

    }

    @Override
    public User findById(Long id) {
        return usersRepository.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersRepository.findByUsername(s);
    }
}

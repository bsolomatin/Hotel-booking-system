package com.bsolomatin.bookingshotel.service;

import com.bsolomatin.bookingshotel.domain.User;
import com.bsolomatin.bookingshotel.forms.UserForm;
import com.bsolomatin.bookingshotel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SignUpServiceImpl implements SignUpService{

    private final UsersRepository usersRepository;

    @Autowired
    public SignUpServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm form) {
    }
}

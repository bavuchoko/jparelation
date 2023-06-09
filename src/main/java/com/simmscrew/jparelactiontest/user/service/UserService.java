package com.simmscrew.jparelactiontest.user.service;

import com.simmscrew.jparelactiontest.mapping.test5.service.Child5JapRepository;
import com.simmscrew.jparelactiontest.mapping.test5.service.GrandChild5JpaRepository;
import com.simmscrew.jparelactiontest.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserJapRepository userJapRepository;

    @Autowired
    Child5JapRepository childJpaRepository;

    @Autowired
    GrandChild5JpaRepository grandChildJpaRepository;

    public List selectAll() {
        return userJapRepository.findAll();
    }


    public User saveUser(User user) {
        User save = userJapRepository.save(user);
        return save;
    }


    public User selectOne(Integer i) {
        return userJapRepository.findById(i).orElse(null);
    }
}

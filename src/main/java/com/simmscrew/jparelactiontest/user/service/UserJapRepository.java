package com.simmscrew.jparelactiontest.user.service;

import com.simmscrew.jparelactiontest.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJapRepository extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll();



}

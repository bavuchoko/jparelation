package com.simmscrew.jparelactiontest.test2.service;

import com.simmscrew.jparelactiontest.test2.Parent_2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Parent2JapRepository extends JpaRepository<Parent_2, Integer> {

    @Override
    List<Parent_2> findAll();

}

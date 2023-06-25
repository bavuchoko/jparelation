package com.simmscrew.jparelactiontest.mapping.test1.service;

import com.simmscrew.jparelactiontest.mapping.test1.Parent_1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Parent1JapRepository extends JpaRepository<Parent_1, Integer> {

    @Override
    List<Parent_1> findAll();

}

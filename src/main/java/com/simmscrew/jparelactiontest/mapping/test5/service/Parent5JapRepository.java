package com.simmscrew.jparelactiontest.mapping.test5.service;

import com.simmscrew.jparelactiontest.mapping.test5.Parent_5;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Parent5JapRepository extends JpaRepository<Parent_5, Integer> {

    @Override
    List<Parent_5> findAll();

}

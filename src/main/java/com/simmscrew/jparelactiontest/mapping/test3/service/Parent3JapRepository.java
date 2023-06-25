package com.simmscrew.jparelactiontest.mapping.test3.service;

import com.simmscrew.jparelactiontest.mapping.test3.Parent_3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Parent3JapRepository extends JpaRepository<Parent_3, Integer> {

    @Override
    List<Parent_3> findAll();

}

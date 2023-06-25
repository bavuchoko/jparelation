package com.simmscrew.jparelactiontest.mapping.test4.service;

import com.simmscrew.jparelactiontest.mapping.test4.Parent_4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Parent4JapRepository extends JpaRepository<Parent_4, Integer> {

    @Override
    List<Parent_4> findAll();

}

package com.simmscrew.jparelactiontest.update.test1.service;

import com.simmscrew.jparelactiontest.update.test1.UpdateParent_1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpdateParent1JapRepository extends JpaRepository<UpdateParent_1, Integer> {

    @Override
    List<UpdateParent_1> findAll();

}

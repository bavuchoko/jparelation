package com.simmscrew.jparelactiontest.test1.service;

import com.simmscrew.jparelactiontest.test1.Child_1;
import com.simmscrew.jparelactiontest.test1.Parent_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class Test1Service {

    @Autowired
    Parent1JapRepository testJapRepository;

    @Autowired
    Child1JapRepository childJpaRepository;

    public List selectAll() {
        return testJapRepository.findAll();
    }


    public Parent_1 insertSet() {
        Parent_1 parent = Parent_1.builder().name("부모" + (testJapRepository.findAll().size()+1) ).build();
        Parent_1 save = testJapRepository.save(parent);

        IntStream.rangeClosed(1,3).forEach(i->{
            Child_1 child = Child_1.builder().name("자식" + i).parent(save).build();
            childJpaRepository.save(child);
            });
        return save;
    }


}

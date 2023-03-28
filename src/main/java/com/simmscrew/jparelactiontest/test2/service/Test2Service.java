package com.simmscrew.jparelactiontest.test2.service;

import com.simmscrew.jparelactiontest.test2.Child_2;
import com.simmscrew.jparelactiontest.test2.Parent_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class Test2Service {

    @Autowired
    Parent2JapRepository testJapRepository;

    @Autowired
    Child2JapRepository childJpaRepository;

    public List selectAll() {
        return testJapRepository.findAll();
    }


    public Parent_2 insertSet() {
        Parent_2 parent = Parent_2.builder().name("부모" + (testJapRepository.findAll().size()+1) ).build();
        Parent_2 save = testJapRepository.save(parent);

        IntStream.rangeClosed(1,3).forEach(i->{
            Child_2 child = Child_2.builder().name("자식" + i).parent(save).build();
            childJpaRepository.save(child);
            });
        return save;
    }

}

package com.simmscrew.jparelactiontest.test3.service;

import com.simmscrew.jparelactiontest.test3.Child_3;
import com.simmscrew.jparelactiontest.test3.Parent_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class Test3Service {

    @Autowired
    Parent3JapRepository testJapRepository;

    @Autowired
    Child3JapRepository childJpaRepository;

    public List selectAll() {
        return testJapRepository.findAll();
    }


    public Parent_3 insertSet() {
        Parent_3 parent = Parent_3.builder().name("부모" + (testJapRepository.findAll().size()+1) ).build();
        Parent_3 save = testJapRepository.save(parent);

        IntStream.rangeClosed(1,3).forEach(i->{
            Child_3 child = Child_3.builder().name("자식" + i).parent(save).build();
            childJpaRepository.save(child);
            });
        return save;
    }


}

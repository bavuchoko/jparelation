package com.simmscrew.jparelactiontest.test4.service;

import com.simmscrew.jparelactiontest.test4.Child_4;
import com.simmscrew.jparelactiontest.test4.GrandChild_4;
import com.simmscrew.jparelactiontest.test4.Parent_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class Test4Service {

    @Autowired
    Parent4JapRepository testJapRepository;

    @Autowired
    Child4JapRepository childJpaRepository;

    @Autowired
    GrandChild4JpaRepository grandChildJpaRepository;

    public List selectAll() {
        return testJapRepository.findAll();
    }


    public Parent_4 insertSet() {
        Parent_4 parent = Parent_4.builder().name("부모" + (testJapRepository.findAll().size()+1) ).build();
        Parent_4 save = testJapRepository.save(parent);

        IntStream.rangeClosed(1,3).forEach(i->{
            extracted(save, i);
        });
        return save;
    }

    private void extracted(Parent_4 save, int i) {
        Child_4 child = Child_4.builder().name("자식" + i).parent(save).build();
        childJpaRepository.save(child);
        IntStream.rangeClosed(1,3).forEach(k->{
            GrandChild_4 grandChild= GrandChild_4.builder().name("손자"+k).parent(save).child(child).build();
            grandChildJpaRepository.save(grandChild);
        });

    }


}

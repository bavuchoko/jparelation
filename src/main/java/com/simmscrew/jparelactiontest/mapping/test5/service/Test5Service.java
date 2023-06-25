package com.simmscrew.jparelactiontest.mapping.test5.service;

import com.simmscrew.jparelactiontest.mapping.test5.*;
import com.simmscrew.jparelactiontest.mapping.test5.idclass.Child5UserId;
import com.simmscrew.jparelactiontest.mapping.test5.idclass.GrandChild5UserId;
import com.simmscrew.jparelactiontest.user.User;
import com.simmscrew.jparelactiontest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Test5Service {

    @Autowired
    Parent5JapRepository testJapRepository;

    @Autowired
    UserService userService;
    @Autowired
    Child5JapRepository childJpaRepository;

    @Autowired
    GrandChild5JpaRepository grandChildJpaRepository;

    @Autowired
    Child5UserJpaRepository child5UserJpaRepository;

    @Autowired
    GrandChildUserJpaRepository grandChildUserJpaRepository;

    public List selectAll() {
        return testJapRepository.findAll();
    }


    public Parent_5 insertSet() {
        User user1 = userService.selectOne(1);
        User user2 = userService.selectOne(2);
        User user3 = userService.selectOne(3);
        User user4 = userService.selectOne(4);
        Parent_5 parent = Parent_5.builder().name("부모" + (testJapRepository.findAll().size()+1) ).user(user1).build();
        Parent_5 save = testJapRepository.save(parent);

        IntStream.rangeClosed(1,3).forEach(i->{
            extracted(save, i,user2,user3,user4);
        });
        return save;
    }

    private void extracted(Parent_5 save, int i, User ...users) {
        Child_5 child = Child_5.builder().name("자식" + i).parent(save).build();
        List<Child5User> members = new ArrayList<>();
        childJpaRepository.save(child);
        List<Child5User> collect = Arrays.stream(users).map(e -> {
            return Child5User.builder().id(Child5UserId.builder().user(e).child(child).build()).build();
        }).collect(Collectors.toList());
        childUserInsert(collect);
        IntStream.rangeClosed(1,3).forEach(k->{
            GrandChild_5 grandChild= GrandChild_5.builder().name("손자"+k).parent(save).child(child).build();
            grandChildJpaRepository.save(grandChild);

            List<GrandChild5User> collect2 = Arrays.stream(users).map(e -> {
                return GrandChild5User.builder().id(GrandChild5UserId.builder().user(e).grandChild(grandChild).build()).build();
            }).collect(Collectors.toList());
            grandChildUserInsert(collect2);
        });

    }


    private void childUserInsert(List<Child5User> collection) {
        child5UserJpaRepository.saveAll(collection);
    }

    private void grandChildUserInsert(List<GrandChild5User> collection) {
        grandChildUserJpaRepository.saveAll(collection);
    }
}

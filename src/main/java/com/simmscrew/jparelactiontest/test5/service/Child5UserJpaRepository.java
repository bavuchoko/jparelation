package com.simmscrew.jparelactiontest.test5.service;

import com.simmscrew.jparelactiontest.test5.Child5User;
import com.simmscrew.jparelactiontest.test5.GrandChild_5;
import com.simmscrew.jparelactiontest.test5.idclass.Child5UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Child5UserJpaRepository extends JpaRepository<Child5User, Child5UserId> {
}

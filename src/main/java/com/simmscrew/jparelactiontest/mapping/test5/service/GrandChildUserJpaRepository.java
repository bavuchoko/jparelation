package com.simmscrew.jparelactiontest.mapping.test5.service;

import com.simmscrew.jparelactiontest.mapping.test5.GrandChild5User;
import com.simmscrew.jparelactiontest.mapping.test5.idclass.GrandChild5UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrandChildUserJpaRepository extends JpaRepository<GrandChild5User, GrandChild5UserId> {

}

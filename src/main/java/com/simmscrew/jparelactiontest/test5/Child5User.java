package com.simmscrew.jparelactiontest.test5;

import com.simmscrew.jparelactiontest.test5.idclass.Child5UserId;
import com.simmscrew.jparelactiontest.test5.idclass.GrandChild5UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Child5User {


    @EmbeddedId
    private Child5UserId id;
}

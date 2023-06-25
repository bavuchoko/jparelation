package com.simmscrew.jparelactiontest.mapping.test5;

import com.simmscrew.jparelactiontest.mapping.test5.idclass.GrandChild5UserId;
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
public class GrandChild5User {

    @EmbeddedId
    private GrandChild5UserId id;
}

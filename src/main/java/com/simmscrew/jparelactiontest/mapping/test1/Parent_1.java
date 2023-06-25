package com.simmscrew.jparelactiontest.mapping.test1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parent_1 {


    /**
     *  [ Entity ]
     *  자식
     *  부모를 가리키는 필드에     @ManyToOne(targetEntity = Parent_1.class, fetch = FetchType.LAZY) @JoinColumn(name = "parent_id")
     *
     *  부모
     *  자식을 가리키는 필드 없음
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Integer id;

    private String name;

}

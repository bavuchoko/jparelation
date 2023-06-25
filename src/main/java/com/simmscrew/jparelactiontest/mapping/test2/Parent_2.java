package com.simmscrew.jparelactiontest.mapping.test2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parent_2 {


    /**
     *  [ Entity ]
     *  자식
     *  부모를 가리키는 필드     @ManyToOne(targetEntity = Parent_1.class, fetch = FetchType.LAZY) @JoinColumn(name = "parent_id")
     *
     *  부모
     *  자식을 가리키는 필드(컬렉션)     @OneToMany @JoinColumn(name = "child_id")
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Integer id;

    private String name;

    @OneToMany
    @JoinColumn(name = "child_id")
    private List<Child_2> children;


}

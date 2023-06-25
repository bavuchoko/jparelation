package com.simmscrew.jparelactiontest.mapping.test2;

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
public class Child_2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Parent_2.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent_2 parent;
}

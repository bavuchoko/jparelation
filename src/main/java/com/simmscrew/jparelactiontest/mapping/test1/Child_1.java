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
public class Child_1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Parent_1.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent_1 parent;
}

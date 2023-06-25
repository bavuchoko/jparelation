package com.simmscrew.jparelactiontest.mapping.test4;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class GrandChild_4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grandchild_id")
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Parent_4.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Parent_4 parent;

    @ManyToOne(targetEntity = Child_4.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id")
    @JsonBackReference
    private Child_4 child;



}

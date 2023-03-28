package com.simmscrew.jparelactiontest.test4;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Child_4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Parent_4.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Parent_4 parent;

    @OneToMany(mappedBy = "child")
    private List<GrandChild_4> grandChildren;
}

package com.simmscrew.jparelactiontest.test5;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.simmscrew.jparelactiontest.user.User;
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
public class GrandChild_5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grandchild_id")
    private Integer id;

    private String name;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "id.grandChild")
    private List<GrandChild5User> members;

    @ManyToOne(targetEntity = Parent_5.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Parent_5 parent;

    @ManyToOne(targetEntity = Child_5.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id")
    @JsonBackReference
    private Child_5 child;



}

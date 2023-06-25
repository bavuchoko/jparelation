package com.simmscrew.jparelactiontest.update.test1;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateParent_1 {


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



}

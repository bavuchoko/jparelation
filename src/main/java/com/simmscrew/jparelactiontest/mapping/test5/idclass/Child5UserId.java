package com.simmscrew.jparelactiontest.mapping.test5.idclass;

import com.simmscrew.jparelactiontest.mapping.test5.Child_5;
import com.simmscrew.jparelactiontest.user.User;
import lombok.Builder;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Builder
public class Child5UserId implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="child_id")
    private Child_5 child;
}

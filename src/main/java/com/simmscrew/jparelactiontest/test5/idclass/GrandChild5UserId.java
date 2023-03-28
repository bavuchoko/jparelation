package com.simmscrew.jparelactiontest.test5.idclass;

import com.simmscrew.jparelactiontest.test5.GrandChild_5;
import com.simmscrew.jparelactiontest.user.User;
import lombok.Builder;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Builder
public class GrandChild5UserId implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="grandchild_id")
    private GrandChild_5 grandChild;
}

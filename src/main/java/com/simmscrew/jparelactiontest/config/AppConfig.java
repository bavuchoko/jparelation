package com.simmscrew.jparelactiontest.config;

import com.simmscrew.jparelactiontest.user.User;
import com.simmscrew.jparelactiontest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class AppConfig {
    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Autowired
            UserService userService;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                User user1 = User.builder()
                        .name("user1")
                        .build();
                userService.saveUser(user1);
                User user2 = User.builder()
                        .name("user2")
                        .build();
                userService.saveUser(user2);
                User user3 = User.builder()
                        .name("user3")
                        .build();
                userService.saveUser(user3);
                User user4 = User.builder()
                        .name("user4")
                        .build();
                userService.saveUser(user4);

            }
        };

    }


}

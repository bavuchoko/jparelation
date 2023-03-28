package com.simmscrew.jparelactiontest.user;

import com.simmscrew.jparelactiontest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(userService.selectAll());
    }


    @GetMapping("select")
    public ResponseEntity select() {
        return ResponseEntity.ok().body(userService.selectOne(1));
    }

}

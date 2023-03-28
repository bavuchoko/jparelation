package com.simmscrew.jparelactiontest.test4;

import com.simmscrew.jparelactiontest.test4.service.Test4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/test4")
public class Test4Controller {

    @Autowired
    Test4Service testService;
    @GetMapping("insert")
    public ResponseEntity one() {
        IntStream.rangeClosed(1,3).forEach((i)->{
            testService.insertSet();
        } );
        return ResponseEntity.ok().body(testService.selectAll());
    }
    @GetMapping("list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(testService.selectAll());
    }
}

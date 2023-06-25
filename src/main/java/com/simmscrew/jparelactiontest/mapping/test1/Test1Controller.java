package com.simmscrew.jparelactiontest.mapping.test1;

import com.simmscrew.jparelactiontest.mapping.test1.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/test1")
public class Test1Controller {


    //부모에는 아무 설정 없고 자식에만     @ManyToOne, @JoinColumn 설정  ->  부모를 조회했을때 딸린 자식은 조회되지 않음
    @Autowired
    Test1Service testService;
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

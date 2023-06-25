package com.simmscrew.jparelactiontest.mapping.test2;

import com.simmscrew.jparelactiontest.mapping.test2.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/test2")
public class Test2Controller {


    //부모에는 @OneToMany, @JoinColumn   자식에는 @ManyToOne, @JoinColumn 설정  ->  부모1입력 -> 자식1입력 -> 자식2입력... 할 때 부모1의 자식외래키 때문에 에러발생

    @Autowired
    Test2Service testService;
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

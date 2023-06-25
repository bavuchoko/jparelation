package com.simmscrew.jparelactiontest.mapping.test3;

import com.simmscrew.jparelactiontest.mapping.test3.service.Test3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/test3")
public class Test3Controller {


    //부모에는 @OneToMany(mappedBy = "parent")   자식에는 @ManyToOne, @JoinColumn 설정  ->  부모 조회시 딸린 자식까지 같이 조회됨  mappedby 의 "parent" 는 자식엔티티에 있는 부모타입의 필드명.

    @Autowired
    Test3Service testService;
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

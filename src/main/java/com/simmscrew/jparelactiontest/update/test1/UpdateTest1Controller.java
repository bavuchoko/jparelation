package com.simmscrew.jparelactiontest.update.test1;

import com.simmscrew.jparelactiontest.mapping.test1.Parent_1;
import com.simmscrew.jparelactiontest.update.test1.service.UpdateTest1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/updatetest")
public class UpdateTest1Controller {


    //부모에는 @OneToMany, @JoinColumn   자식에는 @ManyToOne, @JoinColumn 설정  ->  부모1입력 -> 자식1입력 -> 자식2입력... 할 때 부모1의 자식외래키 때문에 에러발생

    @Autowired
    UpdateTest1Service testService;
    @GetMapping("insert")
    public ResponseEntity one() {

        testService.insertSet();
        return ResponseEntity.ok().body(testService.selectAll());
    }


    @GetMapping("list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(testService.selectAll());
    }


    @PostMapping("update")
    public ResponseEntity update() {

        testService.update();
        List<UpdateParent_1> p1 = testService.selectAll();
        return ResponseEntity.ok().body(p1);
    }

    @PostMapping("updateflush")
    public ResponseEntity updateFlush() {

        testService.updateFlush();
        List<UpdateParent_1> p1 = testService.selectAll();
        return ResponseEntity.ok().body(p1);
    }

}

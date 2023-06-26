package com.simmscrew.jparelactiontest.update.test1;

import com.simmscrew.jparelactiontest.mapping.test1.Parent_1;
import com.simmscrew.jparelactiontest.update.test1.service.UpdateTest1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/updatetest")
public class UpdateTest1Controller {


    /**
     * @Transactional 이 걸려있을경우 영속성 상태의 엔티티에 set 만 해도 transaction 이 끝나는 시점에 영구저장소(DB)에도 업데이트 반영됨.
     * 트랜잭션 어노테이션을 걸지 않을 경우 동일한 id 로 세팅된 엔티티를 save 할경우 update 됨.
     * */
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


    @PostMapping("jpaupdate")
    public ResponseEntity update() {

        testService.jpaUpdate();
        List<UpdateParent_1> p1 = testService.selectAll();
        return ResponseEntity.ok().body(p1);
    }
    @PostMapping("jpaupdateTx")
    public ResponseEntity update2() {

        testService.jpaUpdateTx();
        List<UpdateParent_1> p1 = testService.selectAll();
        return ResponseEntity.ok().body(p1);
    }

    @PostMapping("rpupdate")
    public ResponseEntity updateFlush() {

        testService.rpUpdate();
        List<UpdateParent_1> p1 = testService.selectAll();
        return ResponseEntity.ok().body(p1);
    }
    @PostMapping("rpupdatetx")
    public ResponseEntity updateFlushTx() {

        testService.rpUpdateTx();
        List<UpdateParent_1> p1 = testService.selectAll();
        return ResponseEntity.ok().body(p1);
    }


}

package com.simmscrew.jparelactiontest.update.test1.service;

import com.simmscrew.jparelactiontest.mapping.test1.service.Parent1JapRepository;
import com.simmscrew.jparelactiontest.update.test1.UpdateParent_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UpdateTest1Service {

    @Autowired
    UpdateParent1JapRepository testJapRepository;


    public List selectAll() {
        return testJapRepository.findAll();
    }


    public UpdateParent_1 insertSet() {
        UpdateParent_1 parent = UpdateParent_1.builder().name("저장").build();
        UpdateParent_1 save = testJapRepository.save(parent);
        return save;
    }

    public UpdateParent_1 update() {
        UpdateParent_1 p1 = testJapRepository.findById(1).get();
        p1.setName("수정");
        return p1;
    }

    public UpdateParent_1 updateFlush() {
        UpdateParent_1 p1 = testJapRepository.findById(1).get();
        p1.setName("수정");
        return testJapRepository.save(p1);
    }
}

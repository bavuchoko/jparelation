package com.simmscrew.jparelactiontest.update.test1.service;

import com.simmscrew.jparelactiontest.mapping.test1.service.Parent1JapRepository;
import com.simmscrew.jparelactiontest.update.test1.UpdateParent_1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateTest1Service {

    private final EntityManager em;

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

    public UpdateParent_1 jpaUpdate() {
        UpdateParent_1 p1 = em.find(UpdateParent_1.class, 1);
        p1.setName("jp수정");
        return p1;
    }

    public UpdateParent_1 rpUpdate() {
        UpdateParent_1 p1 = testJapRepository.findById(1).get();
        p1.setName("rp수정");
        UpdateParent_1 updated = testJapRepository.save(p1);
        return updated;
    }


    @Transactional
    public UpdateParent_1 rpUpdateTx() {
        UpdateParent_1 p1 = testJapRepository.findById(1).get();
        p1.setName("rp수정Tx");
        UpdateParent_1 updated = testJapRepository.findById(1).get();
        return updated;
    }

    @Transactional
    public UpdateParent_1 jpaUpdateTx() {
        UpdateParent_1 p1 = em.find(UpdateParent_1.class, 1);
        p1.setName("jpTx수정");
        return p1;
    }
}

package com.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.domain.entities.TestEntity;
import com.domain.repositories.TestRepository;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Transactional
    public void save(TestEntity testEntity) {
        testRepository.saveTest(testEntity);
    }
}

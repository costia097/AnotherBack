package com.domain.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.domain.entities.TestEntity;

@Repository
public class TestRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTest(TestEntity testEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(testEntity);
    }
}

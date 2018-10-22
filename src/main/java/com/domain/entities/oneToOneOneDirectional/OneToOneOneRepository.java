package com.domain.entities.oneToOneOneDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToOneOneRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Human human,Heart heart) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(heart);
        currentSession.save(human);
    }

    @Transactional(readOnly = true)
    public Human getById(Long id) {
        return sessionFactory.getCurrentSession().get(Human.class, id);
    }
}

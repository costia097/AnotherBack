package com.domain.entities.OneToManyBidirectional.v1;

import com.domain.entities.OneToManyBidirectional.v1.entity.Planet;
import com.domain.entities.OneToManyBidirectional.v1.entity.SolarSystem;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToManyBRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(SolarSystem solarSystem) {
        sessionFactory.getCurrentSession().save(solarSystem);
    }

    @Transactional(readOnly = true)
    public Planet find() {
        Planet planet = sessionFactory.getCurrentSession().find(Planet.class, 2L);
        Hibernate.initialize(planet.getSolarSystem());
        return planet;
    }
}

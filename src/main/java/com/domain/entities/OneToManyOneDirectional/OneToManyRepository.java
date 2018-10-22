package com.domain.entities.OneToManyOneDirectional;

import com.domain.entities.OneToManyOneDirectional.entity.Car;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToManyRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Car car) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(car);
    }

    @Transactional(readOnly = true)
    public Car findCar(Long id) {
        Car car = sessionFactory.getCurrentSession().find(Car.class, id);
        Hibernate.initialize(car.getWheels());
        return car;
    }
}

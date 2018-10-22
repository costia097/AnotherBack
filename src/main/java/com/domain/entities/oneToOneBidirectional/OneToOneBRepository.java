package com.domain.entities.oneToOneBidirectional;

import com.domain.entities.oneToOneBidirectional.entites.Country;
import com.domain.entities.oneToOneBidirectional.entites.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToOneBRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Country country, Language language) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(country);
        currentSession.save(language);
    }

    @Transactional(readOnly = true)
    public Country findCountry(Long id) {
        return sessionFactory.getCurrentSession().get(Country.class, id);
    }
}

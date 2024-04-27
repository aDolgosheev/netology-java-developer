package ru.dolgosheev.homeworkdaohibernate.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import ru.dolgosheev.homeworkdaohibernate.entity.Person;

import java.util.List;

@org.springframework.stereotype.Repository
@AllArgsConstructor
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
                .setParameter("city",city).getResultList();
    }
}

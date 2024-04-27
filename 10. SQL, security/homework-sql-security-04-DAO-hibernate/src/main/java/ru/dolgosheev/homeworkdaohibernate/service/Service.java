package ru.dolgosheev.homeworkdaohibernate.service;

import ru.dolgosheev.homeworkdaohibernate.entity.Person;
import ru.dolgosheev.homeworkdaohibernate.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
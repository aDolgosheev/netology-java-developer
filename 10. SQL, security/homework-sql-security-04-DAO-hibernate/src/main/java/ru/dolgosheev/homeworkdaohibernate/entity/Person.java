package ru.dolgosheev.homeworkdaohibernate.entity;

import jakarta.persistence.*;
import lombok.*;


//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(columnDefinition = "varchar(16) default 'Номер не указан'")
    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;
}

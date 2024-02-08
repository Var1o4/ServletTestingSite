package com.example.yadaun.dao;


import com.example.yadaun.entity.Person;

import java.util.List;

public interface PersonDao {
    boolean addPerson(Person person);
    boolean updatePerson(Person person);
    boolean deletePerson(int id);
    List<Person> showPeople();
    Person findPersonById(int id);
}

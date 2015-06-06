package mh.michael.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mh.michael.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}

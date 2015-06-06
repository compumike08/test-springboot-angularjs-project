package mh.michael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mh.michael.model.Person;
import mh.michael.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List findPersons(){
        return personRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Integer id){
        return personRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person person){
        person.setId(null);
        return personRepository.saveAndFlush(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@RequestBody Person updatedPerson, @PathVariable Integer id){
        updatedPerson.setId(id);
        return personRepository.saveAndFlush(updatedPerson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Integer id){
        personRepository.delete(id);
    }

}

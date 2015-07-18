package mh.michael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import mh.michael.service.PersonDto;
import mh.michael.service.PersonService;

@RestController
@RequestMapping("/persons")
@Configuration
@ComponentScan("mh.michael.service")
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PersonDto> findPersons(){
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonDto getPerson(@PathVariable Integer id){
        return personService.getOnePerson(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PersonDto addPerson(@RequestBody PersonDto personDto){
        personDto.setId(null);
        return personService.savePerson(personDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PersonDto updatePerson(@RequestBody PersonDto updatedPersonDto, @PathVariable Integer id){
        updatedPersonDto.setId(id);
        return personService.savePerson(updatedPersonDto);
    }

    @RequestMapping(value = "/linkItem/{personId}/{itemId}", method = RequestMethod.PUT)
    public PersonDto linkItemToPerson(@PathVariable Integer personId, @PathVariable Integer itemId){
        return personService.linkItemToPerson(itemId, personId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }

}

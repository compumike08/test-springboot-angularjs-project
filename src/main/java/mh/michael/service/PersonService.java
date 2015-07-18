package mh.michael.service;

import mh.michael.model.Person;

import java.util.List;

/**
 * Created by Michael on 7/17/2015.
 */
public interface PersonService {

    public List<PersonDto> getAllPersons();

    public PersonDto getOnePerson(Integer id);

    public PersonDto savePerson(PersonDto personDto);

    public void deletePerson(Integer id);

    public PersonDto linkItemToPerson(Integer itemId, Integer personId);

    public Person getOnePersonDirect(Integer id);
}

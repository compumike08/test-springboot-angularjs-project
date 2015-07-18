package mh.michael.service;

import mh.michael.model.Item;
import mh.michael.model.Person;
import mh.michael.repository.ItemRepository;
import mh.michael.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Michael on 7/18/2015.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ItemService itemService;

    private PersonItemDtoHelper personItemDtoHelper;

    public PersonServiceImpl(){
        super();
        this.personItemDtoHelper = new PersonItemDtoHelper();
    }

    @Override
    public List<PersonDto> getAllPersons(){
        List<Person> allPersons = personRepository.findAll();

        //Convert list of Person objects to list of PersonDto objects
        List<PersonDto> allPersonsDtos = personItemDtoHelper.convertPersonListToPersonDtoList(allPersons);

        return allPersonsDtos;
    }

    @Override
    public PersonDto getOnePerson(Integer id){
        Person person = personRepository.findOne(id);

        //Convert Person object to PersonDto object
        PersonDto personDto = personItemDtoHelper.convertPersonToPersonDto(person);

        return personDto;
    }

    @Override
    public Person getOnePersonDirect(Integer id){
        return personRepository.findOne(id);
    }

    @Override
    public PersonDto savePerson(PersonDto personDto){
        Person person = personItemDtoHelper.convertPersonDtoToPerson(personDto);

        Person savedPerson = personRepository.saveAndFlush(person);

        PersonDto savedPersonDto = personItemDtoHelper.convertPersonToPersonDto(savedPerson);

        return savedPersonDto;
    }

    @Override
    public void deletePerson(Integer id){
        personRepository.delete(id);
    }

    @Override
    public PersonDto linkItemToPerson(Integer itemId, Integer personId){
        Person person = getOnePersonDirect(personId);
        Item item = itemService.getOneItemDirect(itemId);

        if((person != null) && (item != null)) {
            person.addOwnedItem(item);
        }else{
            throw new IllegalStateException("Either person or item could not be found for either personId or itemId provided to PersonService.linkItemToPerson.");
        }

        Person savedPerson = personRepository.saveAndFlush(person);

        PersonDto savedPersonDto = personItemDtoHelper.convertPersonToPersonDto(savedPerson);
        return savedPersonDto;
    }
}

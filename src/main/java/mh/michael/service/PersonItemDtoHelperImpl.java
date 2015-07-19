package mh.michael.service;

import mh.michael.model.Item;
import mh.michael.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 7/18/2015.
 */

@Service
public class PersonItemDtoHelperImpl implements PersonItemDtoHelper {
    @Autowired
    private PersonService personService;

    public PersonItemDtoHelperImpl() {
        super();
    }

    /**
     * convertPersonToPersonDto
     *
     * Converts a Person object into a PersonDto object
     *
     * @param person the Person object to be converted
     * @return       the PersonDto object converted from person
     */
    @Override
    public PersonDto convertPersonToPersonDto(Person person){
        PersonDto personDto = new PersonDto();

        if(person != null) {
            personDto.setId(person.getId());
            personDto.setLastName(person.getLastName());
            personDto.setFirstName(person.getFirstName());
            personDto.setOwnedItems(convertItemListToOwnedItemDtoList(person.getOwnedItems()));
        }else{
            personDto = null;
        }

        return personDto;
    }

    /**
     * convertPersonDtoToPerson
     *
     * Converts a Person object into a PersonDto object
     *
     * @param personDto the PersonDto object to be converted
     * @return          the Person object converted from personDto
     */
    @Override
    public Person convertPersonDtoToPerson(PersonDto personDto){
        Person person = new Person();

        if(personDto != null) {
            person.setId(personDto.getId());
            person.setLastName(personDto.getLastName());
            person.setFirstName(personDto.getFirstName());
        }else{
            person = null;
        }

        return person;
    }

    @Override
    public Item convertOwnedItemDtoToItem(OwnedItemDto ownedItemDto){
        Item item = new Item();

        if(ownedItemDto != null) {
            item.setId(ownedItemDto.getId());
            item.setDescription(ownedItemDto.getDescription());
            item.setChecked(ownedItemDto.isChecked());
        }else{
            item = null;
        }

        return item;
    }

    /*
    @Override
    public List<Item> convertItemDtoListToItemList(List<ItemDto> allItemsDtos){
        List<Item> allItems = new ArrayList<Item>();

        if(allItemsDtos != null){
            for(ItemDto itemDto : allItemsDtos){
                Item item = convertItemDtoToItem(itemDto);
                allItems.add(item);
            }
        }else{
            allItems = null;
        }

        return allItems;
    }
    */


    /**
     * convertPersonListToPersonDtoList
     *
     * Converts a list of Person objects into a list of PersonDto objects
     *
     * @param allPersons the list of Person objects to be converted
     * @return           the list of PersonDto objects converted from allPersons list
     */
    @Override
    public List<PersonDto> convertPersonListToPersonDtoList(List<Person> allPersons){
        List<PersonDto> allPersonsDtos = new ArrayList<PersonDto>();

        if(allPersons != null) {
            for (Person person : allPersons) {
                PersonDto personDto = convertPersonToPersonDto(person);
                allPersonsDtos.add(personDto);
            }
        }else{
            allPersonsDtos = null;
        }

        return allPersonsDtos;
    }

    /*
    /**
     * convertPersonDtoListToPersonList
     *
     * Converts a list of PersonDto objects into a list of Person objects
     *
     * @param allPersonsDtos the list of PersonDto objects to be converted
     * @return               the list of Person objects converted from allPersonsDtos list
     */

    /*
    @Override
    public List<Person> convertPersonDtoListToPersonList(List<PersonDto> allPersonsDtos){
        List<Person> allPersons = new ArrayList<Person>();

        if(allPersonsDtos != null) {
            for (PersonDto personDto : allPersonsDtos) {
                Person person = convertPersonDtoToPerson(personDto);
                allPersons.add(person);
            }
        }else{
            allPersons = null;
        }

        return allPersons;
    }
    */



    @Override
    public OwnedItemDto convertItemToOwnedItemDto(Item item){
        OwnedItemDto ownedItemDto = new OwnedItemDto();

        if(item != null) {
            ownedItemDto.setId(item.getId());
            ownedItemDto.setChecked(item.isChecked());
            ownedItemDto.setDescription(item.getDescription());
        }else{
            ownedItemDto = null;
        }

        return ownedItemDto;
    }

    @Override
    public Item convertItemDtoToItem(ItemDto itemDto){
        Item item = new Item();

        if(itemDto != null) {
            item.setId(itemDto.getId());
            item.setChecked(itemDto.isChecked());
            item.setDescription(itemDto.getDescription());
            item.setOwnedBy(convertOwnedByPersonDtoToPerson(itemDto.getOwnedBy()));
        }else{
            item = null;
        }

        return item;
    }

    @Override
    public List<OwnedItemDto> convertItemListToOwnedItemDtoList(List<Item> allItems){
        List<OwnedItemDto> allItemsDtos = new ArrayList<OwnedItemDto>();

        if(allItems != null) {
            for (Item item : allItems) {
                OwnedItemDto ownedItemDto = convertItemToOwnedItemDto(item);
                allItemsDtos.add(ownedItemDto);
            }
        }else{
            allItemsDtos = null;
        }

        return allItemsDtos;
    }

    /*
    @Override
    public List<Item> convertItemDtoListToItemList(List<OwnedItemDto> allItemsDtos){
        List<Item> allItems = new ArrayList<Item>();

        if(allItemsDtos != null) {
            for (OwnedItemDto ownedItemDto : allItemsDtos) {
                Item item = convertItemDtoToItem(ownedItemDto);
                allItems.add(item);
            }
        }else{
            allItems = null;
        }

        return allItems;
    }
    */

    @Override
    public OwnedByPersonDto convertPersonToOwnedByPersonDto(Person person){
        OwnedByPersonDto ownedByPersonDto = new OwnedByPersonDto();

        if(person != null){
            ownedByPersonDto.setId(person.getId());
            ownedByPersonDto.setLastName(person.getLastName());
            ownedByPersonDto.setFirstName(person.getFirstName());
        }else{
            ownedByPersonDto = null;
        }

        return ownedByPersonDto;
    }

    @Override
    public Person convertOwnedByPersonDtoToPerson(OwnedByPersonDto ownedByPersonDto){
        Person person = null;

        if(ownedByPersonDto != null){
            Integer personId = ownedByPersonDto.getId();
            person = personService.getOnePersonDirect(personId);
        }else{
            person = null;
        }

        return person;
    }

    @Override
    public ItemDto convertItemToItemDto(Item item){
        ItemDto itemDto = new ItemDto();

        if(item != null){
            itemDto.setId(item.getId());
            itemDto.setDescription(item.getDescription());
            itemDto.setChecked(item.isChecked());
            itemDto.setOwnedBy(convertPersonToOwnedByPersonDto(item.getOwnedBy()));
        }else{
            itemDto = null;
        }

        return itemDto;
    }

    @Override
    public List<ItemDto> convertItemListToItemDtoList(List<Item> allItems){
        List<ItemDto> allItemsDtos = new ArrayList<ItemDto>();

        if(allItems != null){
            for(Item item : allItems){
                ItemDto itemDto = convertItemToItemDto(item);
                allItemsDtos.add(itemDto);
            }
        }else{
            allItemsDtos = null;
        }

        return allItemsDtos;
    }
}

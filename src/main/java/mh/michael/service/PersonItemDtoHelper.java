package mh.michael.service;

import mh.michael.model.Item;
import mh.michael.model.Person;

import java.util.List;

/**
 * Created by Michael on 7/19/2015.
 */
public interface PersonItemDtoHelper {

    public PersonDto convertPersonToPersonDto(Person person);

    public Person convertPersonDtoToPerson(PersonDto personDto);

    public Item convertOwnedItemDtoToItem(OwnedItemDto ownedItemDto);

    public List<PersonDto> convertPersonListToPersonDtoList(List<Person> allPersons);

    public OwnedItemDto convertItemToOwnedItemDto(Item item);

    public Item convertItemDtoToItem(ItemDto itemDto);

    public Item generateNewItemFromItemDto(ItemDto itemDto);

    public List<OwnedItemDto> convertItemListToOwnedItemDtoList(List<Item> allItems);

    public OwnedByPersonDto convertPersonToOwnedByPersonDto(Person person);

    public ItemDto convertItemToItemDto(Item item);

    public List<ItemDto> convertItemListToItemDtoList(List<Item> allItems);
}

package mh.michael.service;

import mh.michael.model.Item;
import mh.michael.model.Person;

import java.util.List;

/**
 * Created by Michael on 7/19/2015.
 */
public interface PersonItemDtoHelper {

    PersonDto convertPersonToPersonDto(Person person);

    Person convertPersonDtoToPerson(PersonDto personDto);

    Item convertOwnedItemDtoToItem(OwnedItemDto ownedItemDto);

    List<PersonDto> convertPersonListToPersonDtoList(List<Person> allPersons);

    OwnedItemDto convertItemToOwnedItemDto(Item item);

    Item convertItemDtoToItem(ItemDto itemDto);

    List<OwnedItemDto> convertItemListToOwnedItemDtoList(List<Item> allItems);

    OwnedByPersonDto convertPersonToOwnedByPersonDto(Person person);

    Person convertOwnedByPersonDtoToPerson(OwnedByPersonDto ownedByPersonDto);

    ItemDto convertItemToItemDto(Item item);

    List<ItemDto> convertItemListToItemDtoList(List<Item> allItems);
}

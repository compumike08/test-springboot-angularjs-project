package mh.michael.service;

import mh.michael.model.Item;
import mh.michael.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Michael on 7/18/2015.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    private PersonItemDtoHelper personItemDtoHelper;

    public ItemServiceImpl(){
        super();
        this.personItemDtoHelper = new PersonItemDtoHelper();
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> allItems = itemRepository.findAll();

        List<ItemDto> allItemsDtos = personItemDtoHelper.convertItemListToItemDtoList(allItems);

        return allItemsDtos;
    }

    @Override
    public ItemDto getOneItem(Integer id) {
        Item item = itemRepository.findOne(id);

        ItemDto itemDto = personItemDtoHelper.convertItemToItemDto(item);

        return itemDto;
    }

    @Override
    public Item getOneItemDirect(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public ItemDto saveItem(ItemDto itemDto) {
        Item item = personItemDtoHelper.convertItemDtoToItem(itemDto);

        Item savedItem = itemRepository.saveAndFlush(item);

        ItemDto savedItemDto = personItemDtoHelper.convertItemToItemDto(savedItem);

        return savedItemDto;
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }
}

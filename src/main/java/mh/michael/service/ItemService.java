package mh.michael.service;

import mh.michael.model.Item;

import java.util.List;

/**
 * Created by Michael on 7/18/2015.
 */
public interface ItemService {

    public List<ItemDto> getAllItems();

    public ItemDto getOneItem(Integer id);

    public ItemDto saveNewItem(ItemDto itemDto);

    public ItemDto updateExistingItem(ItemDto itemDto);

    public Item saveItemDirect(Item item);

    public void deleteItem(Integer id);

    public Item getOneItemDirect(Integer id);

}

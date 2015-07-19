package mh.michael.controller;

import java.util.List;

import mh.michael.service.ItemDto;
import mh.michael.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/items")
@Configuration
@ComponentScan("mh.michael.service")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List findItems(){
        return itemService.getAllItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ItemDto getItem(@PathVariable Integer id){
        return itemService.getOneItem(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        itemDto.setId(null);
        return itemService.saveNewItem(itemDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ItemDto updateItem(@RequestBody ItemDto updatedItemDto, @PathVariable Integer id){
        updatedItemDto.setId(id);
        return itemService.updateExistingItem(updatedItemDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id){
        itemService.deleteItem(id);
    }
}

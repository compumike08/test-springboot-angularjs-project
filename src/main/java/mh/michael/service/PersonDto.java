package mh.michael.service;

/**
 * Created by Michael on 7/17/2015.
 */

import java.util.List;

public class PersonDto {
    private Integer id;
    private String lastName;
    private String firstName;

    private List<OwnedItemDto> ownedItems;

    public PersonDto() {
        this.id = null;
        this.lastName = null;
        this.firstName = null;
        this.ownedItems = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<OwnedItemDto> getOwnedItems() {
        return ownedItems;
    }

    public void setOwnedItems(List<OwnedItemDto> ownedItems) {
        this.ownedItems = ownedItems;
    }
}

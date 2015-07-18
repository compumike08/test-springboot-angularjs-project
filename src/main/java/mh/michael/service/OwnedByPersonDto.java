package mh.michael.service;

import java.util.List;

/**
 * Created by Michael on 7/18/2015.
 */
public class OwnedByPersonDto {
    private Integer id;
    private String lastName;
    private String firstName;

    public OwnedByPersonDto() {
        this.id = null;
        this.lastName = null;
        this.firstName = null;
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

}

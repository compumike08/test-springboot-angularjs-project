package mh.michael.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @OneToMany(mappedBy = "ownedBy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Item> ownedItems;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public List<Item> getOwnedItems() {
        return ownedItems;
    }

    public void setOwnedItems(List<Item> ownedItems) {
        this.ownedItems = ownedItems;
    }

    public void addOwnedItem(Item ownedItem){
        this.ownedItems.add(ownedItem);
    }
}

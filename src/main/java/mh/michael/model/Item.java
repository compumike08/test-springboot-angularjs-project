package mh.michael.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private boolean checked;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_fk")
    private Person ownedBy;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public boolean isChecked(){
        return checked;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Person getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Person ownedBy) {
        this.ownedBy = ownedBy;
    }

}

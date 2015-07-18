package mh.michael.service;

/**
 * Created by Michael on 7/18/2015.
 */
public class ItemDto {
    private Integer id;
    private boolean checked;
    private String description;

    private OwnedByPersonDto ownedBy;

    public ItemDto() {
        this.id = null;
        this.checked = false;
        this.description = null;
        this.ownedBy = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OwnedByPersonDto getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(OwnedByPersonDto ownedBy) {
        this.ownedBy = ownedBy;
    }
}

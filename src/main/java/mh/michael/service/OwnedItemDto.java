package mh.michael.service;

/**
 * Created by Michael on 7/18/2015.
 */
public class OwnedItemDto {
    private Integer id;
    private boolean checked;
    private String description;

    public OwnedItemDto() {
        this.id = null;
        this.checked = false;
        this.description = null;
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

}

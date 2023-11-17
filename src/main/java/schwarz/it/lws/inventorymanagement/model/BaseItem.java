package schwarz.it.lws.inventorymanagement.model;

public abstract class BaseItem {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

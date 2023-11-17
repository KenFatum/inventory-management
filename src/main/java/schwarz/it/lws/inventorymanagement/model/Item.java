package schwarz.it.lws.inventorymanagement.model;

public class Item extends BaseItem {
    private String name;
    private double price;
    private String category;
    private int quantity;

    public Item() {
    }

    public Item(String name, double price, String category, int quantity) {
        this(null, name, price, category, quantity);
    }

    public Item(Long id, String name, double price, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + category + ", " + quantity;

    }
}



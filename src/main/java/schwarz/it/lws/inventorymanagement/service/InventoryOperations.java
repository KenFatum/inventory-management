package schwarz.it.lws.inventorymanagement.service;

import schwarz.it.lws.inventorymanagement.model.Item;

import java.util.List;

public interface InventoryOperations {
    void addItem(Item item);
    void removeItem(Item item);
    void updateItem(Item item);

    List<Item> findItemByName(String name);

    List<Item> findAllItems();
}

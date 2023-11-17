package schwarz.it.lws.inventorymanagement.repository;

import schwarz.it.lws.inventorymanagement.model.Item;

import java.io.File;
import java.util.List;

public class ItemRepository extends JsonRepository<Item> {

    public ItemRepository(String fileName) {
        super(Item.class, new File(fileName));
    }

    public List<Item> findByName(String name) {
        return findAll().stream()
                .filter(item -> item.getName().equals(name))
                .toList();
    }

    public List<Item> findByCategory(String category) {
        return findAll().stream()
                .filter(item -> item.getCategory().equals(category))
                .toList();
    }
}

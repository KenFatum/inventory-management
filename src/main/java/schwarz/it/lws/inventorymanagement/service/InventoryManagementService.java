package schwarz.it.lws.inventorymanagement.service;

import schwarz.it.lws.inventorymanagement.model.Item;
import schwarz.it.lws.inventorymanagement.repository.ItemRepository;

import java.util.List;

public class InventoryManagementService implements InventoryOperations {

    private final ItemRepository itemRepository;

    public InventoryManagementService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void removeItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.update(item);
    }

    @Override
    public List<Item> findItemByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }
}

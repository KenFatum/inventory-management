package schwarz.it.lws.inventorymanagement.repository;

import org.junit.jupiter.api.Test;
import schwarz.it.lws.inventorymanagement.model.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository("data.json");

    @Test
    void findByName() {
        itemRepository.save(new Item("Item 1", 100, "Category 1", 10));
        itemRepository.save(new Item("Item 2", 100, "Category 2", 20));
        itemRepository.save(new Item("Item 3", 100, "Category 1", 30));

        List<Item> items = itemRepository.findByName("Item 1");
        assertThat(items.size()).isEqualTo(1);

    }

    @Test
    void findByCategory() {
        itemRepository.save(new Item("Item 1", 100, "Category 1", 10));
        itemRepository.save(new Item("Item 2", 100, "Category 2", 20));
        itemRepository.save(new Item("Item 3", 100, "Category 1", 30));

        List<Item> items = itemRepository.findByCategory("Category 1");
        assertThat(items.size()).isEqualTo(4);
    }
}
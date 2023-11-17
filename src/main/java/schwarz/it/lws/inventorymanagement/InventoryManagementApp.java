package schwarz.it.lws.inventorymanagement;

import schwarz.it.lws.inventorymanagement.controller.InventoryManagementController;
import schwarz.it.lws.inventorymanagement.repository.ItemRepository;
import schwarz.it.lws.inventorymanagement.service.InventoryManagementService;

public class InventoryManagementApp {
    public static void main(String[] args) {
        ItemRepository itemRepository = new ItemRepository("items.json");
        InventoryManagementService inventoryManagementService = new InventoryManagementService(itemRepository);
        InventoryManagementController inventoryManagementController = new InventoryManagementController(inventoryManagementService);

        inventoryManagementController.run();
    }
}

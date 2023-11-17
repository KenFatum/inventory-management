package schwarz.it.lws.inventorymanagement.controller;

import schwarz.it.lws.inventorymanagement.model.Item;
import schwarz.it.lws.inventorymanagement.service.InventoryManagementService;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementController {
    private final InventoryManagementService inventoryManagementService;
    private final Scanner scanner = new Scanner(System.in);

    public InventoryManagementController(InventoryManagementService inventoryManagementService) {
        this.inventoryManagementService = inventoryManagementService;
    }

    public void run() {
        while (true) {
            String input = inputCharacterWithPrompt("""
                    Please select an option:
                    1. List all items
                    2. Add an item
                    3. Update an item
                    4. Delete an item
                    5. Exit""", "12345");

            switch (input) {
                case "1" -> findAllItems();
                case "2" -> addNewItem();
                case "3" -> updateItem();
                case "4" -> deleteExistingItemByName();
                case "5" -> System.exit(0);
                default -> System.out.println("Invalid input");
            }
        }
    }

    private void findAllItems() {
        List<Item> items = inventoryManagementService.findAllItems();
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private void updateItem() {
        String nameToUpdate = inputWithPrompt("Please enter the name of the item to update");

        List<Item> existingItems = inventoryManagementService.findItemByName(nameToUpdate);

        if (existingItems.isEmpty()) {
            System.out.println("No item found with name " + nameToUpdate);
            return;
        }

        Long existingId = existingItems.get(0).getId();

        String newName = inputWithPrompt("Please enter the new name");
        Double newPrice = inputDoubleWithPrompt("Please enter the new price");
        String newCategory = inputWithPrompt("Please enter the new category");
        Integer newQuantity = inputIntegerWithPrompt("Please enter the new quantity");


        Item updatedItem = new Item(existingId, newName, newPrice, newCategory, newQuantity);

        inventoryManagementService.updateItem(updatedItem);

        for (Item item : existingItems) {
            if (item.getName().equals(nameToUpdate)) {
                inventoryManagementService.removeItem(item);;
                break;
            }
        }

    }

    private void deleteExistingItemByName() {
        String name = inputWithPrompt("Please enter the name of the item");

        List<Item> items = inventoryManagementService.findAllItems();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                inventoryManagementService.removeItem(item);
                break;
            }
        }
    }

    private void addNewItem() {
        String name = inputWithPrompt("Please enter the name of the item");
        Double price = inputDoubleWithPrompt("Please enter the price of the item");
        String category = inputWithPrompt("Please enter the category of the item");
        Integer quantity = inputIntegerWithPrompt("Please enter the quantity of the item");

        Item item = new Item(name, price, category, quantity);

        inventoryManagementService.addItem(item);
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        return scanner.nextLine();
    }

    private String inputCharacterWithPrompt(String prompt, String allowedCharacters) {
        System.out.println(prompt);
        System.out.print("> ");
        while (true) {
            String character = scanner.nextLine();
            if (allowedCharacters.contains(character)) {
                return character;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private Double inputDoubleWithPrompt(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a float number");
            }
        }
    }

    private Integer inputIntegerWithPrompt(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number");
            }
        }
    }
}

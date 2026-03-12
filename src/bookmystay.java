import java.io.*;
import java.util.*;

class bookmystay {

    static final String FILE_NAME = "inventory.dat";

    public static void main(String[] args) {

        System.out.println("System Recovery");

        Map<String, Integer> inventory = loadInventory();

        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));

        saveInventory(inventory);

        System.out.println("Inventory saved successfully.");
    }

    // Load inventory from file
    public static Map<String, Integer> loadInventory() {

        Map<String, Integer> inventory = null;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            inventory = (Map<String, Integer>) in.readObject();
            in.close();
        }
        catch (Exception e) {

            System.out.println("No valid inventory data found. Starting fresh.");

            inventory = new HashMap<>();
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        return inventory;
    }

    // Save inventory to file
    public static void saveInventory(Map<String, Integer> inventory) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(inventory);
            out.close();
        }
        catch (Exception e) {
            System.out.println("Error saving inventory.");
        }
    }
}
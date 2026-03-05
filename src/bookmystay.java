import java.util.HashMap;

class bookmystay {

    HashMap<String, Integer> inventory;

    bookmystay() {
        inventory = new HashMap<>();
        inventory.put("Standard", 10);
        inventory.put("Deluxe", 5);
        inventory.put("Suite", 2);
    }

    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    void displayInventory() {
        for (String room : inventory.keySet()) {
            System.out.println(room + " Rooms Available: " + inventory.get(room));
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Welcome to Book My Stay App   ");
        System.out.println("   Hotel Booking System v3.1     ");
        System.out.println("=================================");

        bookmystay inventorySystem = new bookmystay();

        System.out.println("\nCurrent Room Inventory:");
        inventorySystem.displayInventory();
    }
}
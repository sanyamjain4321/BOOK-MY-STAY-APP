import java.util.HashMap;

class bookmystay {

    HashMap<String, Integer> inventory;
    HashMap<String, Double> prices;

    bookmystay() {
        inventory = new HashMap<>();
        prices = new HashMap<>();

        inventory.put("Standard", 10);
        inventory.put("Deluxe", 5);
        inventory.put("Suite", 0);

        prices.put("Standard", 2000.0);
        prices.put("Deluxe", 3500.0);
        prices.put("Suite", 5000.0);
    }

    void searchRooms() {
        for (String room : inventory.keySet()) {
            int available = inventory.get(room);
            if (available > 0) {
                System.out.println(room + " Room - Price: ₹" + prices.get(room) + " | Available: " + available);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Welcome to Book My Stay App   ");
        System.out.println("   Hotel Booking System v4.0     ");
        System.out.println("=================================");

        bookmystay app = new bookmystay();

        System.out.println("\nAvailable Rooms:");
        app.searchRooms();
    }
}
import java.util.*;

class bookmystay {

    public static void main(String[] args) {

        // Inventory before cancellation
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);

        // Existing reservation
        String reservationId = "Single-1";
        String roomType = "Single";

        // Stack to track rollback history
        Stack<String> rollbackStack = new Stack<>();

        System.out.println("Booking Cancellation");

        // Validate reservation
        if (reservationId != null && !reservationId.isEmpty()) {

            // Record released room ID
            rollbackStack.push(reservationId);

            // Restore inventory
            inventory.put(roomType, inventory.get(roomType) + 1);

            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);

            System.out.println("\nRollback History (Most Recent First):");

            while (!rollbackStack.isEmpty()) {
                System.out.println("Released Reservation ID: " + rollbackStack.pop());
            }

            System.out.println("\nUpdated Single Room Availability: " + inventory.get("Single"));
        }
        else {
            System.out.println("Cancellation failed. Reservation does not exist.");
        }
    }
}
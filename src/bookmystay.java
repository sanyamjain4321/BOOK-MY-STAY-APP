import java.util.*;

class BookingRequest {
    String guestName;
    String roomType;

    BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class bookmystay {

    public static void main(String[] args) {

        // Queue for booking requests (FIFO)
        Queue<BookingRequest> requestQueue = new LinkedList<>();

        requestQueue.add(new BookingRequest("Abhi", "Single"));
        requestQueue.add(new BookingRequest("Subha", "Single"));
        requestQueue.add(new BookingRequest("Vanmathi", "Suite"));

        // Inventory of rooms
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Suite", 2);

        // Map room type to allocated room IDs
        Map<String, Set<String>> allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single", new HashSet<>());
        allocatedRooms.put("Suite", new HashSet<>());

        System.out.println("Room Allocation Processing");

        while (!requestQueue.isEmpty()) {

            BookingRequest request = requestQueue.poll();
            String roomType = request.roomType;

            if (inventory.get(roomType) > 0) {

                Set<String> roomSet = allocatedRooms.get(roomType);

                // Generate unique room ID
                String roomId = roomType + "-" + (roomSet.size() + 1);

                // Ensure uniqueness
                while (roomSet.contains(roomId)) {
                    roomId = roomType + "-" + (roomSet.size() + 1);
                }

                roomSet.add(roomId);

                // Update inventory
                inventory.put(roomType, inventory.get(roomType) - 1);

                System.out.println("Booking confirmed for Guest: "
                        + request.guestName + ", Room ID: " + roomId);
            }
        }
    }
}
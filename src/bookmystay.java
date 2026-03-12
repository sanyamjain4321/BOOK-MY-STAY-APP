import java.util.*;

class BookingRequest {
    String guestName;
    String roomType;

    BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class BookingProcessor extends Thread {

    private Queue<BookingRequest> queue;
    private Map<String, Integer> inventory;
    private Map<String, Integer> roomCounter;

    BookingProcessor(Queue<BookingRequest> queue,
                     Map<String, Integer> inventory,
                     Map<String, Integer> roomCounter) {
        this.queue = queue;
        this.inventory = inventory;
        this.roomCounter = roomCounter;
    }

    public void run() {
        processBooking();
    }

    private synchronized void processBooking() {

        if (queue.isEmpty())
            return;

        BookingRequest request = queue.poll();
        String type = request.roomType;

        int available = inventory.get(type);

        if (available > 0) {

            int id = roomCounter.get(type) + 1;
            roomCounter.put(type, id);

            String roomId = type + "-" + id;

            inventory.put(type, available - 1);

            System.out.println("Booking confirmed for Guest: "
                    + request.guestName + ", Room ID: " + roomId);
        }
    }
}

 class bookmystay {

    public static void main(String[] args) throws Exception {

        System.out.println("Concurrent Booking Simulation");

        Queue<BookingRequest> queue = new LinkedList<>();

        queue.add(new BookingRequest("Abhi", "Single"));
        queue.add(new BookingRequest("Vanmathi", "Double"));
        queue.add(new BookingRequest("Kural", "Suite"));
        queue.add(new BookingRequest("Subha", "Single"));

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        Map<String, Integer> roomCounter = new HashMap<>();
        roomCounter.put("Single", 0);
        roomCounter.put("Double", 0);
        roomCounter.put("Suite", 0);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Thread t = new BookingProcessor(queue, inventory, roomCounter);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads)
            t.join();

        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}
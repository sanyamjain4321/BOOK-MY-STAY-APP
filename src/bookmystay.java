import java.util.*;

class bookmystay {

    Queue<String> bookingQueue;

    bookmystay() {
        bookingQueue = new LinkedList<>();
    }

    void addRequest(String guestName, String roomType) {
        String request = guestName + " requested " + roomType + " room";
        bookingQueue.add(request);
    }

    void showRequests() {
        System.out.println("\nBooking Requests in Queue:");
        for (String req : bookingQueue) {
            System.out.println(req);
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   Welcome to Book My Stay App   ");
        System.out.println("   Hotel Booking System v5.0     ");
        System.out.println("=================================");

        bookmystay app = new bookmystay();

        app.addRequest("Amit", "Standard");
        app.addRequest("Priya", "Deluxe");
        app.addRequest("Rahul", "Suite");
        System.out.println("---------------------------------");

        app.showRequests();
    }
}
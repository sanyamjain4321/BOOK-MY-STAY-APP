import java.util.*;

class Reservation {
    String guestName;
    String roomId;
    String roomType;

    Reservation(String guestName, String roomId, String roomType) {
        this.guestName = guestName;
        this.roomId = roomId;
        this.roomType = roomType;
    }
}

class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getReservations() {
        return history;
    }
}

class BookingReportService {

    public static void generateReport(List<Reservation> reservations) {

        System.out.println("Booking History Report");

        for (Reservation r : reservations) {
            System.out.println("Guest: " + r.guestName +
                    ", Room ID: " + r.roomId +
                    ", Room Type: " + r.roomType);
        }

        System.out.println("Total Bookings: " + reservations.size());
    }
}

class bookmystay {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // confirmed bookings (simulated)
        history.addReservation(new Reservation("Abhi", "Single-1", "Single"));
        history.addReservation(new Reservation("Subha", "Single-2", "Single"));
        history.addReservation(new Reservation("Vanmathi", "Suite-1", "Suite"));

        // admin generates report
        BookingReportService.generateReport(history.getReservations());
    }
}
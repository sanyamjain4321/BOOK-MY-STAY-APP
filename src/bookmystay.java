import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class bookmystay
{

    static Set<String> validRoomTypes = new HashSet<>(Arrays.asList("Single", "Double", "Suite"));

    public static void validateBooking(String roomType) throws InvalidBookingException {
        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Booking Validation");

        System.out.print("Enter guest name: ");
        String guestName = sc.nextLine();

        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = sc.nextLine();

        try {
            validateBooking(roomType);
            System.out.println("Booking confirmed for Guest: " + guestName);
        }
        catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        sc.close();
    }
}
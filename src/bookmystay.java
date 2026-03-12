import java.util.*;

class Service {
    String name;
    double cost;

    Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class AddOnServiceManager {

    Map<String, List<Service>> reservationServices = new HashMap<>();

    public void addService(String reservationId, Service service) {

        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);
    }

    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<Service> services = reservationServices.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.cost;
            }
        }

        return total;
    }
}

 class bookmystay {

    public static void main(String[] args) {

        String reservationId = "Single-1";

        AddOnServiceManager manager = new AddOnServiceManager();

        Service spa = new Service("Spa", 1000);
        Service airportPickup = new Service("Airport Pickup", 500);

        manager.addService(reservationId, spa);
        manager.addService(reservationId, airportPickup);

        double totalCost = manager.calculateTotalCost(reservationId);

        System.out.println("+-------------------------------+");
        System.out.println("| Add-On Service Selection      |");
        System.out.println("| Reservation ID: " + reservationId +"      |");
        System.out.println("| Total Add-On Cost: " + totalCost + "     |");
        System.out.println("+-------------------------------+");
    }
}
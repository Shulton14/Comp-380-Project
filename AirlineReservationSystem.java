import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Name: Flight
 * Date: November 22, 2024
 * Programmer: Maxim Petroff
 *
 * This class represents a flight in the airline reservation system. It handles
 * flight details such as flight number, destination, capacity, and the number
 * of seats booked. It provides methods to book or cancel seats and to check seat availability.
 *
 * Important Functions:
 * - {@link #isAvailable()}: Checks if seats are available (Input: None; Output: boolean).
 * - {@link #bookSeat()}: Books a seat if available (Input: None; Output: Updates seat count).
 * - {@link #cancelSeat()}: Cancels a seat if booked (Input: None; Output: Updates seat count).
 *
 * Data Structures:
 * - Fields: flightNumber (String), destination (String), capacity (int), seatsBooked (int).
 *
 * Algorithm:
 * Simple validation logic is used to ensure no overbooking or invalid cancellations.
 */
class Flight {
    String flightNumber;
    String destination;
    int capacity;
    int seatsBooked;

    /**
     * Constructs a new Flight.
     *
     * @param flightNumber the flight number
     * @param destination  the destination of the flight
     * @param capacity     the total capacity of the flight
     */
    public Flight(String flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.seatsBooked = 0;
    }

    /**
     * Checks if seats are available on this flight.
     *
     * @return true if seats are available, false otherwise
     */
    public boolean isAvailable() {
        return seatsBooked < capacity;
    }

    /**
     * Books a seat on the flight if available.
     */
    public void bookSeat() {
        if (isAvailable()) {
            seatsBooked++;
            System.out.println("Seat booked successfully.");
        } else {
            System.out.println("No seats available on this flight.");
        }
    }

    /**
     * Cancels a seat booking on the flight if any bookings exist.
     */
    public void cancelSeat() {
        if (seatsBooked > 0) {
            seatsBooked--;
            System.out.println("Seat canceled successfully.");
        } else {
            System.out.println("No bookings to cancel.");
        }
    }

    /**
     * Provides a string representation of the flight.
     *
     * @return a string containing the flight's details
     */
    public String toString() {
        return "Flight Number: " + flightNumber + ", Destination: " + destination + ", Capacity: " + capacity
                + ", Seats Booked: " + seatsBooked;
    }
}

/**
 * Class Name: Customer
 * Date: November 22, 2024
 * Programmer: Maxim Petroff
 *
 * This class represents a customer in the airline reservation system.
 * It stores basic customer details such as name and email.
 *
 * Important Functions:
 * - {@link #toString()}: Provides a string representation of the customer (Input: None; Output: String).
 *
 * Data Structures:
 * - Fields: name (String), email (String).
 */
class Customer {
    String name;
    String email;

    /**
     * Constructs a new Customer.
     *
     * @param name  the name of the customer
     * @param email the email address of the customer
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Provides a string representation of the customer.
     *
     * @return a string containing the customer's details
     */
    public String toString() {
        return "Customer Name: " + name + ", Email: " + email;
    }
}

/**
 * Class Name: ReservationSystem
 * Date: November 22, 2024
 * Programmer: Maxim Petroff
 *
 * This class manages flights and customers in the airline reservation system.
 * It provides methods to add new flights and customers, display them, and
 * book or cancel seats on flights.
 *
 * Important Functions:
 * - {@link #addFlight(Flight)}: Adds a flight to the system (Input: Flight; Output: Updates flight list).
 * - {@link #addCustomer(Customer)}: Adds a customer to the system (Input: Customer; Output: Updates customer list).
 * - {@link #viewFlights()}: Displays all flights in the system (Input: None; Output: Console output).
 * - {@link #viewCustomers()}: Displays all customers in the system (Input: None; Output: Console output).
 * - {@link #searchFlight(String)}: Searches for a flight by number (Input: String; Output: Flight or null).
 * - {@link #bookSeat(String)}: Books a seat on a flight (Input: String; Output: Updates seat count).
 * - {@link #cancelSeat(String)}: Cancels a booking on a flight (Input: String; Output: Updates seat count).
 *
 * Data Structures:
 * - flights (ArrayList): Stores Flight objects.
 * - customers (ArrayList): Stores Customer objects.
 *
 * Algorithm:
 * A simple linear search is used in {@link #searchFlight(String)} to locate flights by flight number.
 * This approach is effective for small datasets typical in this context.
 */
class ReservationSystem {
    ArrayList<Flight> flights = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Adds a flight to the system.
     *
     * @param flight the flight to be added
     */
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Adds a customer to the system.
     *
     * @param customer the customer to be added
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Displays all flights in the system.
     */
    public void viewFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    /**
     * Searches for a flight by flight number.
     *
     * @param flightNumber the flight number to search for
     * @return the flight if found, or null if not found
     */
    public Flight searchFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Books a seat on a flight if available.
     *
     * @param flightNumber the flight number of the flight to book
     */
    public void bookSeat(String flightNumber) {
        Flight flight = searchFlight(flightNumber);
        if (flight != null) {
            flight.bookSeat();
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Cancels a seat booking on a flight if possible.
     *
     * @param flightNumber the flight number of the flight to cancel
     */
    public void cancelSeat(String flightNumber) {
        Flight flight = searchFlight(flightNumber);
        if (flight != null) {
            flight.cancelSeat();
        } else {
            System.out.println("Flight not found.");
        }
    }

    /**
     * Displays all customers in the system.
     */
    public void viewCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

/**
 * Class Name: AirlineReservationSystem
 * Date: November 22, 2024
 * Programmer: Maxim Petroff
 *
 * This is the main class for the Airline Reservation System. It provides
 * a menu-driven console interface to manage flights, customers, and bookings.
 *
 * Important Functions:
 * - {@link #main(String[])}: The entry point of the program (Input: String[]; Output: None).
 *
 * Data Structures:
 * - Scanner: Reads user input.
 * - ReservationSystem: Manages flights and customers.
 *
 * Algorithm:
 * A menu-driven switch-case approach is used for user interaction and system navigation.
 */
public class AirlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        system.addFlight(new Flight("AI101", "New York", 200));
        system.addFlight(new Flight("AI102", "London", 150));
        system.addFlight(new Flight("AI103", "Dubai", 100));

        system.addCustomer(new Customer("Alice", "alice@example.com"));
        system.addCustomer(new Customer("Bob", "bob@example.com"));

        while (true) {
            System.out.println("\nAirline Reservation System:");
            System.out.println("1. View Flights");
            System.out.println("2. View Customers");
            System.out.println("3. Book a Flight");
            System.out.println("4. Cancel a Flight");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    system.viewFlights();
                    break;
                case 2:
                    system.viewCustomers();
                    break;
                case 3:
                    System.out.print("Enter flight number to book: ");
                    String flightNumber = scanner.next();
                    system.bookSeat(flightNumber);
                    break;
                case 4:
                    System.out.print("Enter flight number to cancel: ");
                    String cancelFlightNumber = scanner.next();
                    system.cancelSeat(cancelFlightNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
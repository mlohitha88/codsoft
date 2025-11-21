// Simple Hotel Reservation System in Java
// Console-based application

import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }
}

class Reservation {
    int roomNumber;
    String customerName;

    Reservation(int roomNumber, String customerName) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-added rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));

        int choice;
        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Admin: Add Room");
            System.out.println("5. Admin: Remove Room");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    addRoom();
                    break;
                case 5:
                    removeRoom();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.type + ")");
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number to book: ");
        int rn = sc.nextInt();
        sc.nextLine();
        for (Room r : rooms) {
            if (r.roomNumber == rn && !r.isBooked) {
                System.out.print("Enter customer name: ");
                String name = sc.nextLine();
                r.isBooked = true;
                reservations.add(new Reservation(rn, name));
                System.out.println("Room booked successfully!");
                return;
            }
        }
        System.out.println("Room not available.");
    }

    static void cancelReservation() {
        System.out.print("Enter room number to cancel: ");
        int rn = sc.nextInt();
        for (Reservation res : reservations) {
            if (res.roomNumber == rn) {
                reservations.remove(res);
                for (Room r : rooms) {
                    if (r.roomNumber == rn) r.isBooked = false;
                }
                System.out.println("Reservation cancelled.");
                return;
            }
        }
        System.out.println("No reservation found.");
    }

    static void addRoom() {
        System.out.print("Enter new room number: ");
        int rn = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter room type: ");
        String type = sc.nextLine();
        rooms.add(new Room(rn, type));
        System.out.println("Room added.");
    }

    static void removeRoom() {
        System.out.print("Enter room number to remove: ");
        int rn = sc.nextInt();
        rooms.removeIf(r -> r.roomNumber == rn);
        reservations.removeIf(res -> res.roomNumber == rn);
        System.out.println("Room removed.");
    }
}

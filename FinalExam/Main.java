package FinalExam;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        	//Instance of the Reservation System
            ReservationSystem system = new ReservationSystem();

         // The program runs in a loop until the user chooses to exit.
            while (true) {
            	 // Displaying the main menu options to the user.
                System.out.println("\nRESTAURANT RESERVATION SYSTEM");
                System.out.println("System Menu");
                System.out.println("a/A. View all Reservations");
                System.out.println("b/B. Make Reservation");
                System.out.println("c/C. Delete Reservation");
                System.out.println("d/D. Generate Report");
                System.out.println("e/E. Exit");

                // Asks the user to enter their choice.
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine().toLowerCase();

             // Processing the user's choice using a switch statement.
                switch (choice) {
                    case "a":
                        system.viewAllReservations();
                        break;
                    case "b":
                        system.makeReservation();
                        break;
                    case "c":
                        system.deleteReservation();
                        break;
                    case "d":
                        system.generateReport();
                        break;
                    case "e":
                        System.out.println("Thank you for creating your Reservation!");
                        System.out.println("Thank you po Sir Nelson Gaspar");
                        System.out.println("By: John Louie Ubias");
                        System.out.println("2 BSIT-2");
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid option");
                }
             // Adding a Thread.sleep for loading animation.
                System.out.print("\nLoading...\n");
                Thread.sleep(2000);

            }
            // Catches any error occurs and to inform about any interruptions that occur during the execution of the program. 
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



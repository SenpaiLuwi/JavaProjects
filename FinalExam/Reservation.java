package FinalExam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Private Instance Variables
class Reservation {
    private String name;
    private String date;
    private String time;
    private int adults;
    private int children;

//Constructor for the Reservation
    public Reservation(String name, String date, String time, int adults, int children) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.adults = adults;
        this.children = children;
    }
    
//Getter Methods for getSubtotal (number of adults * 500 + children * 300)
    public int getSubtotal() {
        return adults * 500 + children * 300;
    }

  //Getter Methods for getName
    public String getName() {
        return name;
    }

  //Getter Methods for getDate
    public String getDate() {
        return date;
    }
    
  //Getter Methods for getTime
    public String getTime() {
        return time;
    }
    
  //Getter Methods for getAdults
    public int getAdults() {
        return adults;
    }

  //Getter Methods for getChildren
    public int getChildren() {
        return children;
    }

   // Getter Methods for toString using String.format() method is used to format the string representation.
   //%s: This is a placeholder for a string value.
   //%d: This is a placeholder for an integer value.
    //(-) The negative sign, left-aligns the value within the specified width.
    public String toString() {
        return String.format("%-24s %-27s %-30s %-23d %-20d", date, time, name, adults, children);
    }
}

//Class for the Reservation System
class ReservationSystem {
	// Private Instance of the Array List using ArrayList and List. 
    private List<Reservation> reservations;
    //Constructor  for the Array List
    public ReservationSystem() {
        this.reservations = new ArrayList<>();
    }
    
  //VIEW ALL RESERVATIONS
    public void viewAllReservations() {
    	//Validation if there is reservation.
        if (reservations.isEmpty()) {
            System.out.println("\nThere are no Reservations.");
            return;
        }
        //Listing of the  reservation.
        System.out.println("\n# Date\t\t\t\tTime\t\t\t\tName\t\t\t\tAdults\t\tChildren");
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            System.out.printf("%d %s%n", i + 1, r.toString());
        }
    }

    
   //MAKE A RESERVATION
    public void makeReservation() {
    	//Scanner for the input
        Scanner scanner = new Scanner(System.in);
        //Variables to store the Data
        String name, date, time;
        int adults, children;

        //Enter the Name
        while (true) {
            System.out.print("\nEnter name: ");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("Please enter a name.");
        }

        //Enter the Date using  Regex
        while (true) {
            System.out.print("\nEnter Date (MMMM DD, YYYY): ");
            date = scanner.nextLine();
            if (date.matches("^[A-Z][a-z]{1,4} \\d{1,2}, \\d{4}$")) {
                break;
            }
            System.out.println("Please enter a valid date (ex: Apr 21, 2021).");
        }

        //Enter the Time  using  Regex
        while (true) {
            System.out.print("\nEnter Time (hh:mm AM/PM): ");
            time = scanner.nextLine();
            if (time.matches("^\\d{1,2}:\\d{2} (AM|PM|am|pm)$")) {
                break;
            }
            System.out.println("Please enter a valid time (ex: 12:30 PM).");
        }

        //Enter the Adults & Children 
        adults = getIntegerInput(scanner, "\nEnter number of Adults: ");
        children = getIntegerInput(scanner, "Enter number of Children: ");

        Reservation reservation = new Reservation(name, date, time, adults, children);
        reservations.add(reservation);
        System.out.println("\nReservation has been made.");
    }

    
    //DELETE A RESERVATION
    public void deleteReservation() {
        if (reservations.isEmpty()) {
            System.out.println("\nThere are no Reservations.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        int reservationNumber;

        while (true) {
            reservationNumber = getIntegerInput(scanner, "\nEnter reservation number to delete: ");
            if (reservationNumber >= 1 && reservationNumber <= reservations.size()) {
                break;
            }
            System.out.println("Reservation not found.");
        }

        Reservation reservation = reservations.remove(reservationNumber - 1);
        System.out.printf("Reservation for %s on %s at %s has been deleted.%n", reservation.getName(),
                reservation.getDate(), reservation.getTime());
    }

  //GENERATE REPORT  
    public void generateReport() {
        if (reservations.isEmpty()) {
            System.out.println("\nThere are no Reservations.");
            return;
        }
        
     // Tab of the Report
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tREPORT");
        System.out.println("#  Date\t\t\t\tTime\t\t\tName\t\t\tAdults\t\tChildren\t\tSubtotal");

        // Instance Variables
        int subtotal = 0;
        int totalAdults = 0;
        int totalChildren = 0;

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            subtotal += r.getSubtotal();
            totalAdults += r.getAdults();
            totalChildren += r.getChildren();
            System.out.printf("%d %s\t\t%d%n", i + 1, r.toString(), r.getSubtotal());
        }

        System.out.println("\nTotal number of Adults: " + totalAdults);
        System.out.println("Total number of Children: " + totalChildren);
        System.out.println("Grand Total: PHP " + subtotal);
    }

    //Validation for Int Input
    private int getIntegerInput(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value < 1) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number greater than zero.");
            }
        }
        return value;
    }
}

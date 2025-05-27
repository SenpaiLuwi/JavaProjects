package Act9;

import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter item name: ");
     String itemName = scanner.nextLine().toUpperCase();

     System.out.print("Enter item price: ");
     double itemPrice = scanner.nextDouble();

     scanner.nextLine(); // Consume the remaining newline character

     System.out.print("Enter item brand: ");
     String itemBrand = scanner.nextLine().toUpperCase();

     Phone item = new Phone(itemName, itemPrice);
     Device device = new Device(itemName, itemPrice, itemBrand);

     System.out.println("\n------------------------- Item -------------------------");
     item.displayInfo();
     item.calculateDiscount(10);

     System.out.println("\n------------------------- Device --------------------------");
     device.displayInfo();
     device.calculateDiscount(20);
     device.greetInfo();

     scanner.close();
 }
}

package Act9;

//Parent class
class Phone {
String name;
double price;

public Phone(String name, double price) {
   this.name = name;
   this.price = price;
}

public void displayInfo() {
   System.out.println("Name: \t\t\t\t" + name);
   System.out.println("Price: \t\t\t\t" + price);
}

public void calculateDiscount(double discountPercentage) {
   double discountedPrice = price - (price * discountPercentage / 100);
   System.out.println("Discounted price: \t" + discountedPrice);
}
}

//Child class
class Device extends Phone {
String brand;

public Device(String name, double price, String brand) {
   super(name, price);
   this.brand = brand;
}

//Overrides 
public void displayInfo() {
   super.displayInfo();
   System.out.println("Brand: \t\t\t\t" + brand);
}

public void greetInfo() {
   System.out.println("\nHello! Your Item is  " + brand + " " + name + "\nHave a Good Day Shoppers" );
}
}


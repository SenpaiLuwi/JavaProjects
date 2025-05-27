package Act5;

public class Main {

	public static void main(String[] args) {
			//Dog 1
			Dog dog1 = new Dog();	
			
			dog1.name = "Bulldog";
			dog1.size = "Large";
			dog1.color = "Light Gray";
			dog1.age = "5 Years";

			System.out.println(dog1.name);
			System.out.println("The Breed of the Dog is "  + dog1.name + " ,Size " + dog1.size + " ,Color " + dog1.color + " ,Age " + dog1.age);
			dog1.eat("Beef");
			dog1.run("Playground");
			dog1.sleep(5);
			dog1.name("Rucks");
			
			System.out.println();
			
			//Dog 2
			Dog dog2 = new Dog();	
			
			dog2.name = "Beagle";
			dog2.size = "Large";
			dog2.color = "Orange";
			dog2.age = "6 Years";

			System.out.println(dog2.name);
			System.out.println("The Breed of the Dog is "  + dog2.name + " ,Size " + dog2.size + " ,Color " + dog2.color + " ,Age " + dog2.age);
			dog2.eat("Fruits");
			dog2.run("Living Roon");
			dog2.sleep(4);
			dog2.name("Gorou");
			
			System.out.println();
			
			//Dog 3
			Dog dog3 = new Dog();	
			
			dog3.name = "German Shepherd";
			dog3.size = "Large";
			dog3.color = "White & Orange";
			dog3.age = "6 Years";

			System.out.println(dog3.name);
			System.out.println("The Breed of the Dog is "  + dog3.name + " ,Size " + dog3.size + " ,Color " + dog3.color + " ,Age " + dog3.age);
			dog3.eat("Chicken");
			dog3.run("Bedroom");
			dog3.sleep(8);
			dog3.name("Hina");
	}

}

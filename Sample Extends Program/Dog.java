package Act5;

public class Dog {
		public String name;
		public String size;
		public String color;
		public String age;
		

		void eat(String dogEat) {
			System.out.println("The "+ name + " is Eating a/an " + dogEat);
		}
		
		void run(String dogRun) {
			System.out.println(name + " is running in the " + dogRun);
		}
		
		void sleep(int dogSleep) {
			System.out.println("The " + name + " Sleeps " + dogSleep + " hours");
		}
		
		void name(String dogName) {
			System.out.println("The Name of the " + name + " is " + dogName);
		}

}

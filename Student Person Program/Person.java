package Act8;
import java.util.Calendar;

class Person {
	//Declaration of instance variables
    private String name;
    private int yob;
    private int age;

    //Declaration of the constructor for the "Person"
    public Person(String name, int yob) {
        this.name = name;
        this.yob = yob;
        this.age = getAge();
    }

    //Instance variable of Name
    public String getName() {
        return this.name;
    }

    //Instance variable of YOB
    public int getYOB() {
        return this.yob;
    }

    //Calculates the age of the person by getting the current year using the Calendar class and subtracting the YOB
    public int getAge() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        return currentYear - this.yob;
    }

    //Sets the value of the Name
    public void setName(String name) {
        this.name = name;
    }

   //sets the value of the YOB and the Age
    public void setYOB(int yob) {
        this.yob = yob;
        this.age = getAge();
    }
    
    //Prints the Main Information of the Person
    public void printInfo() {
        System.out.println("Name: \t\t\t\t\t\t" + this.name);
        System.out.println("Year of Birth: \t\t\t\t\t" + this.yob);
        System.out.println("Age: \t\t\t\t\t\t" + this.age);
    }
}
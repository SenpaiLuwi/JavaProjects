package Act8;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			// Get user input for Person class
			System.out.print("Enter name: ");
			String name = scanner.nextLine().toUpperCase();

			System.out.print("Enter year of birth: ");
			int yob = scanner.nextInt();

			// Get user input for Student class
			System.out.print("Enter student ID: ");
			int studID = scanner.nextInt();
			scanner.nextLine();
			
			// Get user input for Major Subject
			System.out.print("Enter major: ");
			String major = scanner.nextLine().toUpperCase();

			// Get user input for the Number of Students
			System.out.print("Enter number of students: ");
			int nos = scanner.nextInt();

			// Create Student object
			Student student = new Student(name, yob, studID, major, nos);

			// Print Student info
			System.out.println();
			System.out.print("------------------------------------------------------------------------------------------------------");
			System.out.println("\n");
			student.printInfo();
		}
    }
}

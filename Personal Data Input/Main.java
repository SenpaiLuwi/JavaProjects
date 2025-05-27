package Act6;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
System.out.println(
				"---------------------------------------PERSONAL DATA---------------------------------------");	

try (Scanner input = new Scanner (System.in)) {
	//PERSONAL INFORMATION
	System.out.print("First Name: ");
	String firstname = input.nextLine();
	
	System.out.print("Middle Initial: ");
	String middleintial = input.nextLine();
	
	System.out.print("Last Name: ");
	String lastname = input.nextLine();
	
	System.out.print("Age: ");
	int age = input.nextInt();
	input.nextLine();
	
	System.out.print("Gender: ");
	String gender = input.nextLine();
	
	System.out.print("Birth Date: ");
	String birthdate = input.nextLine();
	
	System.out.print("Place of Birth: ");
	String birthplace = input.nextLine();
	
	System.out.print("Religion: ");
	String religion = input.nextLine();
	
	System.out.print("Civil Status: ");
	String civilstatus= input.nextLine();
	
	System.out.println("");
	
	//CONTACT INFORMATION
	System.out.print("Street/Barangay: ");
	String street = input.nextLine();
	
	System.out.print("City/Municipality: ");
	String city = input.nextLine();
	
	System.out.print("Province: ");
	String province = input.nextLine();
	
	System.out.print("Email Address: ");
	String email = input.nextLine();
	
	System.out.print("Contact Number: ");
	String contact = input.nextLine();
	
	System.out.println("");
	
	//GOVERNMENT ID'S
	System.out.print("SSS Number: ");
	String SSS = input.nextLine();
	
	System.out.print("Tin Number: ");
	String Tin = input.nextLine();
	
	System.out.print("Pag-Ibig Number: ");
	String pagibig = input.nextLine();
	
	System.out.print("PhilHealth Number: ");
	String philhealth = input.nextLine();
		
		
	PersonalData profile = new PersonalData(firstname,middleintial,lastname,age,gender,birthdate,birthplace,religion,civilstatus,
																			street,city,province,email,contact,
																			SSS,Tin,pagibig,philhealth);
	profile.PrintPersonalData();
}
	}
}

package Act7;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(
				"---------------------------------------PERSONAL DATA---------------------------------------");	
try (Scanner input = new Scanner (System.in)) {		
	//Ask's the user for the Information
	System.out.print("Employee ID: ");
	String employeeID = input.nextLine().toUpperCase();
	
	System.out.print("Last Name: ");
	String lastName = input.nextLine().toUpperCase();
	
	System.out.print("First Name: ");
	String firstName = input.nextLine().toUpperCase();
	
	System.out.print("Middle Initial: ");
	String middleIntital  = input.nextLine().toUpperCase();
	
	System.out.println();
	
	//Ask's the user for their Earnings
	System.out.print("Basic Allowance: ");
	int basicAllowance = input.nextInt();
	
	System.out.print("Incentive Pay: ");
	int incentivePay = input.nextInt();
	
	System.out.print("House Rent Allowance: ");
	int houseRentAllowance = input.nextInt();
	
	System.out.print("Meal Allowance: ");
	int mealAllowance  = input.nextInt();
	
	System.out.println();
	
	//Ask's the user for their Deductions
	System.out.print("Provident Fund: ");
	int providentFund = input.nextInt();
	
	System.out.print("Incentive Pay: ");
	int professionalTax = input.nextInt();
	
	System.out.print("House Rent Allowance: ");
	int loan = input.nextInt();

	//These Lines will compute the different parts of the allowance
	int earnings = basicAllowance + incentivePay + houseRentAllowance + mealAllowance;
	int deductions =  providentFund + professionalTax + loan;
	int netPay = earnings - deductions;

	//Objects for the Employee
	Employee e = new Employee(employeeID,lastName,firstName,middleIntital,
            basicAllowance,incentivePay,houseRentAllowance,
            mealAllowance, providentFund,professionalTax, loan,
            earnings,deductions,netPay);
	
	
	//These Lines will print out the Pay-Slip of the Employee
	System.out.println();
	System.out.println("-------------------------------------------EMPLOYEES PAYSLIP-----------------------------------------");
	System.out.println();
	System.out.println("Employee ID: " + e.getEmployeeID());
	System.out.println("Employee Name: " + e.getFirstName() + " " + e.getMiddleInitial() + " "+ e.getLastName());
	
	System.out.println();
	System.out.println("----------------------------------------EMPLOYEES EARNINGS----------------------------------------");
	System.out.println();
	
	System.out.println("Basic Allowance: \t\t\t" + e.getBasicAllowance());
	System.out.println("Incentive Pay: \t\t\t" + e.getIncentivePay());
	System.out.println("House Rest Allowance: \t" + e.getHouseRentAllowance());
	System.out.println("Meal Allowance: \t\t\t" + e.getMealAllowance());
	
	System.out.println();
	System.out.println("---------------------------------------EMPLOYEES DEDUCTIONS-------------------------------------");
	System.out.println();
	
	System.out.println("Provident Fund: \t\t\t" + e.getProvidentFund());
	System.out.println("Professional Tax: \t\t\t" + e.getProfessionalTax());
	System.out.println("Loan: \t\t\t\t\t" + e.getLoan());
	
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------------------------------");
	System.out.println();
	
	System.out.println("Total Earnings: \t\t\t"  + e.getEarnings());
	System.out.println("Total Deductions: \t\t" + e.getDeductions());
	System.out.println("NET PAY: \t\t\t\t" + e.getNetPay());
}		
}
}

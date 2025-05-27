package Act1;
import java.util.Scanner;
public class Act1 
{
	public static void main(String[] args)
	{				
		boolean Loop = true;
		try (Scanner input = new Scanner(System.in)) 
		{
			//String of the Students
			String[] IDNumber = {"2022-001", "2022-002", "2022-003", "2022-004"};
			String[] StudentName = {"James Cooper ", "Princess Smith ", "Dianna Ross", "James Butler"};
			String[] CollegeProgram = {"BSIT", "BSCS", "BSIS", "BSEMC"};
			String[] SportsName = {"Basketball", "Badminton", "Swimming", "Baseball"};
			String[] ContactNumber = {"0920864756", "09178765454", "09167657382", "09108877635"};
			
			//This will Print The Students
			System.out.print("Students Name:  ");
			for(int s=0; s< 4; s++) 
			{
				System.out.print(StudentName [s]);
				if(s<3)
					System.out.print(", ");
			}

		while(Loop)
		{
			//Input of the user
			System.out.print("\n\n 0 = James Cooper " + " 1 = Princess Smith "  +  " 2 = Dianna Ross" + " 3 = James Butler");
			System.out.print("\n\nEnter Student Index:  ");
			int userInput1 = input.nextInt();
	
			//Printing Process
			System.out.print("\nIndex Number: " + "\t\t\t" + userInput1);
			System.out.print( "\nStudent ID: " + "\t\t\t\t" + IDNumber[userInput1]);
			System.out.print(  "\nName of Student: " + "\t\t" + StudentName[userInput1]);
			System.out.print(  "\nCourse: " +  "\t\t\t\t\t" + CollegeProgram[userInput1]);
			System.out.print(  "\nSportsName: " + "\t\t\t" + SportsName[userInput1]);
			System.out.print( "\nContactNumber No: " + "\t" + ContactNumber[userInput1]);
		}

		}
	}
}


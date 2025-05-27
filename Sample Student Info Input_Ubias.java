package Act3;

import java.util.*;

public class Act3
{
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		boolean Continue = true, Valid, Invalid;
		
		String idInput, NameInput, deptInput, progInput;
		
		ArrayList<String> IDNum = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		ArrayList<String> CollegeDepartment= new ArrayList<String>();
		ArrayList<String> CollegeProgram = new ArrayList<String>();
		ArrayList<ArrayList<String>> studList = new ArrayList<ArrayList<String>>();
		
		studList.add(IDNum);
		studList.add(Name);
		studList.add(CollegeDepartment);
		studList.add(CollegeProgram);
		
		while(Continue) 
		{
			Continue = true;
			Valid = true;
			while(Valid)
			{
			 System.out.println("Enter the Student Information\n ");
				
				System.out.print("Enter ID Number: ");
				idInput = input.nextLine();
				if(idInput.isEmpty()) 
				{
					System.out.println("You Have Not Entered An ID Number!.\n");
				}
				else 
				{
					IDNum.add(idInput);
					Valid = false;
				}
			}
			
			Valid = true;
			while(Valid) 
			{
				System.out.print("Enter Student Full Name: ");
				NameInput = input.nextLine().toUpperCase();
				if(NameInput.isEmpty()) 
				{
					System.out.println("You Have Not Entered Student Name.\n");
				}
				else 
				{
					Name.add(NameInput);
					Valid = false;
				}
			}		
			
			Valid = true;
				
			while(Valid) 
			{
				System.out.print("Enter Student College: ");
				deptInput = input.nextLine().toUpperCase();
				if(deptInput.isEmpty()) 
				{
					System.out.println("You Have Not Entered College.\n");
				}
				else 
				{
					CollegeDepartment.add(deptInput);
					Valid = false;
				}
			}
			
			Valid = true;
			
			while(Valid) 
			{
				System.out.print("Enter Student Program: ");
				progInput = input.nextLine().toUpperCase();
				if(progInput.isEmpty()) 
				{
					System.out.println("You Have Not Entered a Student Program.\n");
				}
				else 
				{
					CollegeProgram.add(progInput);
					Valid = false;
				}
			}
			
			Invalid = true;
			
			while(Invalid) 
			{
				System.out.print("\nDo you want to add more participants? ");
				String contInput = input.nextLine().toUpperCase();
				System.out.println();
				switch(contInput) 
				{
				case "Y":
				case "y":
				case "YES":
				case "Yes":
				case "yes":
					Continue = true;
					Invalid = false;
					break;
				case "N":
				case "n":
				case "NO":
				case "No":
				case "no":
					Continue = false;
					Invalid = false;
					break;
				default:
					System.out.println("Not In The Choices :<");
					Invalid = true;
				}
			}
		}
		
		System.out.println("STUDENT NUMBER\t\tSTUDENT NAME\t\t\t\t\tCOLLEGE\t\t\tPROGRAM");
		
		for(int i = 0; i < studList.get(i).size(); i++) 
		{
			for(int j = 0; j < studList.size(); j++) 
			{
				System.out.print(studList.get(j).get(i) + "\t\t\t\t");
			}
			System.out.println();
		}
		
		input.close();
	}
}

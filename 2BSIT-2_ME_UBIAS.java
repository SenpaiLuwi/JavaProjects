package Midterm;

import java.util.*;

public class Midterm {
	static Scanner input  = new Scanner(System.in); 
	static boolean Programloop = true; 
	
	public static void main(String[] args) 
	{
		System.out.println("\nMidterm Lab Exam Program" + "\nProgrammed by John Louie Ubias");
		while(Programloop)
		{
			mainMenu();
		}
	}
	

	//Main Menu
	static void mainMenu() 
	{	
		int menuInput = 0;
		System.out.println("\nMain Menu: ");
		System.out.println( "\n1. Reverse Word");
		System.out.println("2. Balancing the Parenthesis");
		System.out.println("3. Exit\n");
		
		System.out.print("Enter Option [1-3]: ");
		try 
		{
			menuInput = input.nextInt();
			input.nextLine();
		}
		catch (InputMismatchException e) 
		{
			input.nextLine();
			System.out.println("Input is Invalid. Please only enter a valid Integer value.");
		}

		switch(menuInput) 
		{
		case 1:
			String stringInput;
			System.out.print("\nInput String: ");
			stringInput = input.nextLine(); 
			System.out.println(reverseString(stringInput));
			Programloop = true;
			break;
			
		case 2:
			String ParInput;
			System.out.print("\nInput Parenthesis: ");
			ParInput = input.nextLine();
			System.out.println(parenthesisBalancing(ParInput));
			Programloop = true;
			break;
			
		case 3:
			System.out.println("\nExiting Program! By Ubias, John Louie M.");
			Programloop = false;
			System.exit(0);
			break;
		}
	}
	
	
	
	//Reverse String
	static String reverseString(String input) 
	{
		if(input.length() == 0)
			return "";
		return input.charAt(input.length() -1) + reverseString(input.substring(0, input.length()-1));
	}
	
	
	
	//Parenthesis Checker
static String parenthesisBalancing(String input) 
{
		String balancePar = "";
		String parentheses[] = input.split(" ");

		int openParentheses = 0, closeParentheses = 0, arrSize = parentheses.length;
		if(input.length() != 0) 
		{ 
			for(int c = 0; c < arrSize; c++) 
			{
		
				switch(parentheses[c].charAt(0))
				{
				case '(':
					openParentheses++;
					break;
				case ')':
					closeParentheses++;
					break;
				}
			}
		}
		else 
		{
			balancePar = "Input is Empty.";
			return balancePar;
		}
			if((openParentheses != closeParentheses) || (parentheses[0].charAt(0) == ')') || (parentheses[arrSize-1].charAt(0)) == '(') 
			{ 
				balancePar = "Input is Not Balanced.";
			}
			else 
			{
				balancePar = "Input is Balanced.";
			}
		return balancePar;
	}
	
}

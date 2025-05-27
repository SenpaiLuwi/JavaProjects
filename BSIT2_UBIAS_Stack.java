package Stacks;
import java.util.Scanner;
public class Stacks 
{
	static int topData = -1;
	public static void main(String[] args) throws InterruptedException
	{
		Scanner userInput = new Scanner(System.in);
		boolean exit = false;
		boolean enterStack = true;
		int userMenuChoice = 0;
		int numStacks = 0;
		int data = 0;
		while (enterStack)
			
	{		
try
	{
		System.out.print("How many elements will the stack have: ");
		numStacks = userInput.nextInt();
		if(numStacks > 0)
		{
			enterStack = false;
		}
		else 
		{
			System.out.println("\nError, invalid input please enter positive integers only.\n");
		}
	}
	
catch(Exception e)
		{
			System.out.println("\nError, invalid input, please enter positive integers only.\n");
			userInput.next();
		}
	}
	

int [] stacks = new int [numStacks];
			System.out.println("");

			System.out.println("Stacks Created!\n");
do 
	{
			System.out.println("MENU");
			System.out.println("1. PUSH");
			System.out.println("2. POP");
			System.out.println("3. TOP");
			System.out.println("4. SIZE");
			System.out.println("5. EMPTY");
			System.out.println("6. DISPLAY STACK");
			System.out.println("7. EXIT ");
			System.out.print("Enter Choice [1-7] : ");
			userMenuChoice = userInput.nextInt();
			switch (userMenuChoice)
			{
			
			//Push
			case 1:
			boolean isPush = true;
			while(isPush) 
			{
				try 
			{
					System.out.print("\nEnter number to add to the stack: ");
					data = userInput.nextInt();
					if (data > 0 || data < 0)
			{
					toPush(stacks, data);
					isPush = false;
			}
				else 
			{
					System.out.println("\nError, invalid input please enter positive/negative integers only.");
			}
			}
					catch(Exception e)
			{
					System.out.println("\nError, invalid input please enter positive/negative integers only.");
					userInput.next();
			}
			}
				break;
			

			//Pop
			case 2:
			toPop(stacks, data);
			break;

			//Top
			case 3:
			dispTop(stacks, topData);
			break;
			
			//Size
			case 4:
			dispSize();
			break;

			//Empty
			case 5:
			ifEmpty();
			break;
			
			//Display Stack
			case 6:
			dispStacks(stacks);
			break;

			//Exit
			case 7:
			exit = toExit();
			break;
			
			default:
			System.out.println("Error, out of the choices." + "\n");
			
			 }
				}
					while(!exit);
					userInput.close();
				}
							
	
	
				//toPush (PUSH)
				static void toPush(int [] stacks, int data)
					{
						if(topData == stacks.length-1) 
						{
						System.out.println("Stack Overflow!\n");
						}	
						else 
						{
						++topData; 
						stacks[topData] = data; 
						System.out.println("Stack data: " + data + " successfully pushed\n");
						}
					}
					
						
						
				//toPop (POP)
				static void toPop(int [] stacks, int data)
						{
						if (topData == -1) 
							{
							System.out.println("stack is empty\n");
							}
						else 
							{
							stacks[topData] = 0; 
							--topData; 
							System.out.println("\nSucessfully Popped!\n");
							}
						}
						
				
				
				//displayTop (TOP)
				static void dispTop(int [] stacks, int topData)
						{
						if (topData == -1) 
							{
							System.out.println("\nTop data: " + stacks[++topData] + "\n");
							}
						else 
							{
							System.out.println("\nTop data: " + stacks[topData] + "\n");
							}
						}
							
				
				
				//displaySize (SIZE)
				static void dispSize()
							{
							System.out.println("\nStack Size: " + (topData + 1) + "\n");
							}
				
				
				
				//DispEmpty (EMPTY)
				static void ifEmpty()
						{
						if (topData == -1)
							{
							System.out.println("\nThe Stack is EMPTY!\n");
							}
						else
							{
							System.out.println("\nThe Stack is NOT EMPTY!\n");
							}
						}
						
						
							
				//displayStacks (STACK)
				static void dispStacks(int [] stacks)
						{
								System.out.print("\nStack:");
								for (int i = 0; i < stacks.length; i++)
							{
						if (stacks[i] == 0)
							{
								System.out.print(" , ");
							}
						else 
							{
								System.out.print(" " + stacks[i]);
							}
							}
								System.out.println("\n");
						}
						
							
							
				static boolean toExit()
							{
								System.out.println("\nExiting Program. Program coded by Ubias John Louie M.");
								return true;
								//Sorry po mam Late po nawalan po ng net po ng sun and mon morning lang po nagkaroon.
							}
}

package SecondYear;

import java.util.Scanner;

public class BSIT_2_Ramos_Ubias_Singly {

static Scanner input = new Scanner(System.in);
static Node head;  /*initialize the head of the list*/

static class Node
{
	int data;
	Node next;
	
public Node(int data) /*initialize Constructor of the Node */
	{
		this.data = data;
		this.next = null;
	}
}

public static void main(String[] args) 
{
		int data = 0;
	
		boolean progStillruns = true; 	
		while (progStillruns == true) {
		System.out.println("Main Menu");
		System.out.println("1.Insert at the beginning");
		System.out.println("2.Insert at the End");
		System.out.println("3.Display");
		System.out.println("4.End ");
		System.out.print("\nEnter Input [1-4]: ");
		int choices = input.nextInt();
		
		switch (choices) {
		case 1:
			System.out.println("\nInsert at Beginning");
			data = tryCatchData();
			insertAtBeginning(data);	
			System.out.println();
			break;
			
		case 2:
			System.out.println("\nInsert at End");
			data = tryCatchData();
			insertAtEnd(data);	
			System.out.println();
			break;
			
		case 3:
			System.out.println("\nDisplay");
			display();
			break;
			
		case 4:
			System.out.println("\nTerminate program - programmer's name: Ramos, Dominic, Ubias, JL");
			progStillruns = false;
			break;
			
		default:
			System.out.println("\nInvalid Input, please choose from numbers 1-4 only.");
}
}
}

static void insertAtBeginning(int newData) /*insertion validation at the beginning */
{
	Node newNode = new Node(newData); /*checking the head if null for the next newNode will be null*/
	if(head == null)
		
		newNode.next = null;
	
	newNode.next = head;  /*it will make the new node to be the head*/

	head = newNode;
}

static void insertAtEnd(int newData)  /*insertion validation at the end */
{
	Node newNode = new Node(newData);
	
	Node temp = null;

	newNode.data = newData;
	newNode.next = null;
	
	if(head == null)
		head = newNode;
	
	else 
	{
		temp = head;
		while(temp.next != null) 
			temp = temp.next;
		
		temp.next = newNode;  /*node will be inserted the last part*/
	}
	
}
public static void display()   /*This will display data*/
{
{
	if(head == null) 
	{
		System.out.println(head); 
		return;
	}
	
	Node current = head;
	while (current != null) 
	{
		System.out.print(current.data + " -->");
		current = current.next;
	}
	System.out.println(current);
}
}
static int tryCatchData() 
{
	boolean enter = true;
	int data = 0;
	
	while (enter) 
	{
		try 
		{
			System.out.println();
			System.out.print("Data: ");
			data = input.nextInt();
			
			if (data >= 0 || data <= 0) 
				enter = false;
		}
		catch(Exception e) 
		{
			System.out.println("\nError, data is unknown.");
		    input.next();
		}
	}	
	
	return data;
}
}

						//Copyrights © Dominic O. Ramos & John Louie Ubias from 2BSIT2 NEU 2022

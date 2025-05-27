package java_package;

import java.util.Scanner;

public class BSCS2_Celajes_Jimenez_Soriano_LinkedList {

static Scanner userInput = new Scanner(System.in);
	
	static Node head; //the head of the list
	
	static class Node
	{
		int data;
		Node next;
		
		//Constructor of the Node class
		public Node(int data) 
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) 
	{
		boolean exit = false;
		int data = 0;
		int userChoice = 0;
		
		do 
		{
			System.out.println("MENU ");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			userChoice = tryCatchChoice();
			
			switch (userChoice) 
			{
				case 1:
					System.out.println("\n1. Insert at Beginning");
					System.out.println("2. Insert at End");
					userChoice = tryCatchChoice();
					
						switch(userChoice) 
						{
							case 1:
								data = tryCatchData();
								
								insertAtBeginning(data);	
								System.out.println();
								display();
								break;
								
							case 2:
								data = tryCatchData();
								
								insertAtEnd(data);	
								System.out.println();
								display();
								break;
								
							default:
								System.out.println("Out of the choices...");
						}
					break;
					
				case 2:
					
					data = tryCatchData();
					
					delNode(data);	
					System.out.println();
					display();
					break;	
					
				default:
					System.out.println("Out of the choices...");
			}
			
			boolean enterContinue = true;
			
			//ENTERS USER CHOICE TO CONTINUE OR NOT
			while (enterContinue) 
			{
				try 
				{
					System.out.print("\nContinue?[Y/y or N/n]: ");
					char choice = userInput.next().charAt(0);
					
					if (choice == 'Y' || choice == 'y') 
						enterContinue = false;
					else if (choice == 'N' || choice == 'n') 
					{
						enterContinue = false;
						exit = true;
						System.out.println();
						toExit();
					}
					else 
						System.out.println("\nError, out of the choices.\n");
				}
				catch(Exception e) 
				{
					System.out.println("\nError, please input Y/y or N/n only.\n");
					userInput.next();
				}
			}
			
			System.out.println();
		}while(!exit);
		
		userInput.close();
	}
	
	//INSERTION AT THE BEGINNING USER DEFINED METHOD
	static void insertAtBeginning(int newData) 
	{
		Node newNode = new Node(newData);
		
		//if head is null then the newNode next will be null
		if(head == null)
			newNode.next = null;
		
		//makes next of the new node as the head
		newNode.next = head;
		
		//the head will be the new node
		head = newNode;
	}
	
	//INSERTION AT THE END USER DEFINED METHOD
	static void insertAtEnd(int newData) 
	{
		Node newNode = new Node(newData);
		
		//set temp to null for initialization
		Node temp = null;
		
		//data of new node will be the newData and its next is null
		newNode.data = newData;
		newNode.next = null;
		
		//if head is null then the head will be the newNode
		if(head == null)
			head = newNode;
		
		//temp will be the head and it will traverse till the last node which is currently null
		else 
		{
			temp = head;
			while(temp.next != null) 
				temp = temp.next;
			
			//then the node is inserted at the last part
			temp.next = newNode;
		}
		
	}
	
	static void delNode(int dataDel) 
	{
		//if linked list is empty then immediately return
		if (head == null) 
		{
			System.out.println("\nLinked list is empty.");
			return;
		}
		
		//set node variables to null for initialization
		Node prevNode = null, node = null;
		
		//if head node itself has the data to be deleted
		if(head.data == dataDel) 
		{
			head = head.next; //changes the head
			return; //already stops 
		}
		
		node = head;
		
		//traverses the linked list until it finds the data in that nodes that is going to be deleted
		while(node != null && node.data != dataDel) 
		{
			prevNode = node; //prevNode gets the node 
			node = node.next; //node will then transfer to the next node
		}
		
		//if node is null meaning data was not found
		if (node == null) 
		{
			System.out.println("\nDATA not found.");
			return;
		}
		
		//unlinks the node from the linked list
		//wherein deletion is performed
		//for ex. if 1 is desired to be deleted then from 0 --> 1 --> 2 to 0 --> 2
		//the prevNode.next is 1 and node.next is 2
		//now the prevNode.next will become 2 wherein the prevNode.next that is 1 before is unlinked in the linked list
		prevNode.next = node.next;
	}
	
	//DISPLAY OF CURRENT LINKEDLIST USER DEFINED METHOD
	public static void display() 
	{
		//if linked list becames empty
		if(head == null) 
		{
			System.out.println(head); //simply prints null
			return;
		}
		
		Node current = head;
		
		//prints the linkedlist data
		while (current != null) 
		{
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println(current);
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
				data = userInput.nextInt();
				
				if (data >= 0 || data <= 0) 
					enter = false;
			}
			catch(Exception e) 
			{
				System.out.println("\nError, data is unknown.");
				userInput.next();
			}
		}	
		
		return data;
	}
	
	static int tryCatchChoice() 
	{
		boolean enter = true;
		int choice = 0;
		
		while (enter) 
		{
			try 
			{
				System.out.println();
				System.out.print("Choice: ");
				choice = userInput.nextInt();
				
				if (choice == 1 || choice == 2) 
					enter = false;
				else 
					System.out.println("\nError, out of the choices.");
			}
			catch(Exception e) 
			{
				System.out.println("\nError, choice is unknown.");
				userInput.next();
			}
		}	
		
		return choice;
	}
	
	//USER DEFINED METHOD EXIT
	static void toExit() 
	{
		System.out.println("Programmers' Names: Celajes, Jimenez, Soriano");
	}

}

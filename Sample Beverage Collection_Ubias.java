package Act2;
import java.util.*;
import java.util.Collections; 

public class Act2 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean Loop = true;
		
		//Array List
	    ArrayList<String> customerReceipt = new ArrayList<String>();
	    
		ArrayList<String> beverageName = new ArrayList<String>();
	    beverageName.add("Coke");
	    beverageName.add("Royal");
	    beverageName.add("Sprite");
	    beverageName.add("Zesto");
	    

	    
	    ArrayList<Integer> beveragePrice = new ArrayList<Integer>();
	    beveragePrice.add(20);
	    beveragePrice.add(23);
	    beveragePrice.add(19);
	    beveragePrice.add(25);
	    
	    Integer sum=0;
	    
	    //Looping Method
	    while(Loop) 
	    {
	    	//Checking for the Array / Beverages
	    	System.out.print("Beverage Available: \n");

		    for(int i=0; i<4; i++) 
		    {
		    	System.out.print(beverageName.get(i) + " = P" + beveragePrice.get(i) + "\n");
		    	if(i<beverageName.size()-1)
		    		System.out.print("");
		    }
	       
		    //Purchasing Method
		    System.out.print("\n\nPurchase Beverage: ");
		    String Input = input.nextLine();
		    
		    
		    //Switch Case Method
		    switch(Input) 
		    {

		    //Coke
		    case "Coke":
		    	customerReceipt.add(beverageName.get(0) + " Php " + beveragePrice.get(0));
		    	sum += beveragePrice.get(0);
		    	break;
		    	
		    //Royal
		    case "Royal":
		    	customerReceipt.add(beverageName.get(1) + " Php " + beveragePrice.get(1));
		    	sum += beveragePrice.get(1);
		    	break;

		    //Sprite
		    case "Sprite":
		    	customerReceipt.add(beverageName.get(2) + " Php " + beveragePrice.get(2));
		    	sum += beveragePrice.get(2);
		    	break;

		    //Zesto
		    case "Zesto":
		    	customerReceipt.add(beverageName.get(3) + " Php " + beveragePrice.get(3));
		    	sum += beveragePrice.get(3);
		    	break;
		    	
		    default:
		    	System.out.println("Not in the List! :<  \n");
		    }

		    

		    //Adding another Beverage		    
		    System.out.print("Do you want to add more? [Y / N] ");
		    String continueInput = input.nextLine();
		    
		    switch(continueInput) 
		    {
		    case "Y": case "y":
		    	Loop = true;
		    	break;
		    	
		    case "N": case "n":
		    	Loop = false;
		    	break;
		    	
		    default:
		    	System.out.println("Invalid Input");
		    	
		    }
		    System.out.println("");
		    
	    }
	   
	    //Printing Process of the Beverage
	    System.out.println("Summary of the Purchase");
	    System.out.println("Please Pay your Beverage\n");
	    
	    Collections.sort(customerReceipt);
	    for(int i = 0; i < customerReceipt.size(); i++) 
	    {
	    	System.out.println(customerReceipt.get(i));
	    }
	    System.out.print("\nTotal Amount: " + sum + "\n");
	    System.out.print("Thank You for Purchasing! Programmed by John Louie Ubias");
	    input.close();
	}
}

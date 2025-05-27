package Array;

import java.util.Scanner;
public class Array 

	{
	public static void main(String[] args) 

	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean loopProgram = true;
		
		while(loopProgram == true)
	{
		int option;
		int size = 0;
		int sum = 0;
		
		System.out.print("Choose your option");
		System.out.print("\n\n1 - Sum of Numbers in an Array ");
		System.out.print("\n2 - Maximum and Minimum of Numbers in an Array");
		System.out.print("\n3 - Delete Duplicate Values in an Array");
		System.out.print("\n4 - Terminate Program");
		System.out.print("\n\nOption: "); 
		option = input.nextInt();
		
		switch(option) 
		{
		
case 1:
			
			  //Sum of Numbers in an Array
		      System.out.print("\nInput array size : ");      		      
		      size = input.nextInt();
		      
		      int array[] = new int [size];/* initializes array from user input */
		      
		      System.out.print("\nInput " + size + " values: ");

		      for(int n = 0; n < size; n++)/*stores every user input into the array (max number is based on input array size) */
		      {
		    	  		array[n] = input.nextInt();/*stores every user input in the array */
		    	  		sum = sum + array[n];/*adds the new value in the array while adding it with the previous value (addition)*/
		      }
		    
		      System.out.print("\nSum of " + size + " values " + sum);/*prints out the sum of values */
		      System.out.print("\n\n");
		break;
			
case 2:
		
			//Maximum and Minimum of Numbers in an Array
			
	        int max;
	        int min;
	        int x;
	        int array2[] = new int [100000]; /* initializes array from user input */
	        
	        System.out.print("\nInput array size: ");
	        size = input.nextInt();/*array size from user input */
	        
	        System.out.print("\nInput " + size + " values: ");
	         
	        for(x = 0; x < size; x++) 
	        {
	            	array2[x] = input.nextInt();/*stores every user input into the array (max number is based on input size) */
	        }
	   
	        	max =  array2[0];/*declares max value */
	        	min =  array2[0];/*declares min value */
	         
	        for(x = 0; x < size; x++) /* 10 6 20 26*/
	        {
	            
	        	if(array2[x] >= max)/*26 */
	                
	        		max = array2[x];
	            
	        	else if (array2[x] <= min)/*6 */
	                
	        		min = array2[x];
	                
	        }
	        
	        System.out.println("\nMaximum Value : " + max);
	        System.out.println("Minimum Value : " + min);
	        System.out.println("\n");
	        break;
	        
case 3:
		
			//Delete Duplicate Values in an Array 
			System.out.print("\nInput array size: ");	      
		      
			/* first we will make an array and insert some elements in it. */
		      int number = input.nextInt();
		      int array4[] = new int[number];
		      int array5[] = new int[100000];
		      
		      System.out.print("\nInput " + number + " values: ");	      	      
		      for(int a=0; a < number; a++) 
		      {
		    	 		
		    	  		array4[a] = input.nextInt();
		      		
		     }
		     
		      System.out.print("\nDistinct Value ");
		      for(int a=0; a < number; a++)
		      {
		    	  		array5[array4[a]]++;/*print only those elements which has occurs only one times*/ 
		    	  		if(array5[array4[a]] == 1)/*will not print elements which has occurred more than one times*/
		    	  		{
		            
		    	  				System.out.print(array4[a] + " ");
		    	  			
		    	  		}
		    	  		
		      }
		break;
					
case 4:
			
			//Terminate the Program
			System.out.print("\nProgram Terminated. Programmed by Ubias, John Louie M.");
			loopProgram = false;
		break;
		
		
		
		default:
			//If the user inputs an invalid or not stated option
			System.out.print("\nInvalid Option. Please Choose Again");
			main(args);
				
		break;
	
		}
	
		}
	}
}






package PostfixAndInfix;

import java.util.Scanner;

public class PostAndInfix {

		public static Scanner userInput = new Scanner (System.in);
		public static String pai = " ";
		public static boolean space = false;
		
		//precedence
				static int precedence(char c)
				{ 
			        switch (c){
			           case '+':
			            case '-':
			                return 1;
			            case '*':
			            case '/':
			                return 2;
			            case '^':
			                return 3;
			        }
			        return -1; 
			    }
				
	    public static void main(String[] args)
	    {
	    	System.out.print("\nEnter Infix Notation: ");
	    	pai = userInput.nextLine();	    	
	    	infixValidation();   	

	    	boolean progStillruns = true;
	        while (progStillruns == true) {
	        System.out.println("1. Prefix Notation: ");
	        System.out.println("2. Postfix Notation: ");
	        System.out.println("3. EXIT: ");
	        System.out.print("\nEnter Choice [1..3] : ");

	        System.out.print("\nEnter desired option: ");
	        int select = userInput.nextInt();

	        switch (select) {
	        case 1: 
	            System.out.println("\n\nPrefix Expression: " + PreFix(pai) + "\n\n");
	            break;
	        case 2:
	             System.out.println("\n\nPostfix Expression: " + PostFix(pai) + "\n\n");
	             break;
	        case 3:
	             System.out.println("\n\nProgrammers: Ramos Dominic, Ubias John Louie" + "\n\n");
	             progStillruns = false;
	             System.exit(0);
	             break;
	        default: System.out.println("Invalid Option, Choose only from 1-3");

	        }
	        }
	    }
        static void infixValidation() {
        	
        	int spaceCounter = 0;
    		int cPc = 0;
    		int oPc = 0;
    		int operatorCounter = 0;
    		int operandCounter = 0;
    		int starter = 0;
    		
    		char[] chars = pai.toCharArray(); //character array that can be used to store the variable	
    		for (int i = 0; i < chars.length; i++)
    			
    		{
    		
    			if((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z') || (chars [i] >= '0' && chars [i] <= '9'))  	
    			{
    					starter++;
    					operandCounter++;    				    
    				    if(i > 0) 			    		  
    				    	{    				  	
    				    		operandCounter++;   				    	
    				    	}   					
    				    spaceCounter = 0;
     				 
    				if(operatorCounter != 0)
    					{ 					
    						operatorCounter--;
    						operandCounter = 0;  				
    					}
    			}  			
    			if(chars[i] == '-' || chars[i] == '+' ||
    		       chars[i] == '/' || chars[i] == '*' ||
    			   chars[i] == '^')			
    				{
    				operatorCounter++;
    				spaceCounter = 0;
    				
    				
    				if(spaceCounter != 0)  					  				  
    					{   					
    						spaceCounter = 0;   				
    					}
    			}
    		
	
    			if(chars[i] == '(')
    					{   				
    				starter++;
    				spaceCounter = 0;
    				oPc++;
    		
    				if(spaceCounter != 0)  				  					  
    					{    					
    						spaceCounter = 0;    				
    					}  				
    				if(operatorCounter != 0)      				  					     
    					{		
    						operatorCounter = 0;   					
    					}	
    			}    			
    			if(chars[i] == ')'){
    				
    				spaceCounter = 0;
    				cPc++;
    		
    				if(spaceCounter != 0)                				  
    					{    					
    						spaceCounter = 0;   					
    					}  				
    				if(operatorCounter != 0) 			
    					{   					
    						operatorCounter = 0;    					
    					}
    			}	
    			
    			if(chars[i] == ' ')	
    				{
    				operandCounter--;
    				spaceCounter++;
    				space = true;
    				}  		
 
    			if(spaceCounter == 2)	
    				{
    					System.out.println("\nInfix Notation must not have Multiple Spaces\n");
    					main(null);
    				}   			
    			if(operatorCounter == 2) 								  
    				{    				
    					System.out.println("\nInfix Notation must not have Multiple Operator\n");
    					main(null);   			
    				}    			
    			if(operandCounter == 2)	
    				{
    					System.out.println("\nInfix Notation must not have Multiple Operand\n");
    					main(null);
    				}  			    			
    			if(starter == 0)
                {
    				System.out.println("\nInfix Notation Must Start with an Operand\n");
                    main(null);
                }		
    		}
    	
    		if(oPc != cPc)    					  
    			{	
    				System.out.println("\nInsufficient Amount of Perenthesis\n");    	
    				main(null);
    			}	
        }
        
        
        
        //PreFix
        static String PreFix(String p){ 
	    	int charHolder = p.length();
	        char[] revString = new char[charHolder];
	        
	        for (int i = 0; i < charHolder; i++) {
	        	revString[charHolder - i - 1] = p.charAt(i);	
	         
	        }
	        System.out.print("\nReversed Infix: ");
	        for(int c = 0; c < revString.length; c++) {
	        	
	        	System.out.print(revString[c]);
	        	
	        }
	        System.out.print("\n");
	    	
	    	char[] prefixArray; 
	        char[] prefixString; 
	         
	        prefixArray = new char[p.length() + 100];
	        prefixString = new char[p.length() + 100];
	        
	        
	        int prefixSize = -1;
	        int prefixStringSize = 0;
	        
	        char operatorVal = 0;
	        
	        System.out.print("Scanned Character: ");
	        for(int c = 0; c < revString.length; c++) {
	        	
	        	System.out.print(revString[c]);
	        	
	        }
	       
	        
	        for (int i = 0; i < revString.length; i++) { 
	        
	            
	            switch (revString[i]) {             
	                case '+':
	                case '-':
	                case '/':
	                case '*':
	                case '^':	                	
	                    if (prefixSize == -1){ 
	                        operatorVal = revString[i];
	                    	++prefixSize;
	                        prefixArray[prefixSize] = operatorVal;	                        	                        
	                    }
	                    else if (prefixSize > -1){	                        
	                        if ((precedence(prefixArray[prefixSize]) > precedence(revString[i]))){ 	                                                
	                        		int d = prefixSize ;       
	                        			while(d > -1) {
	                                    	
	                                    	if((precedence(prefixArray[prefixSize]) < precedence(revString[i]))) {		                                    	
		                                    	break;		                                    	
		                                    }
	                                    	
	                                    	prefixString[prefixStringSize] = prefixArray[prefixSize];
		                                    ++prefixStringSize;
		                                    --prefixSize;	
		                                    d--;
	                                    }
	                        			operatorVal = revString[i];	
	                                    ++prefixSize;
	                                    prefixArray[prefixSize] = operatorVal;    
	                        }
	                        else if ((precedence(prefixArray[prefixSize]) == precedence(revString[i])) 
	                        		|| (precedence(prefixArray[prefixSize]) < precedence(revString[i])))
	                        {	                        	
	                        	operatorVal = revString[i];	
	                        	++prefixSize;
	                        	prefixArray[prefixSize] = operatorVal;                                                      
	                        }	                        
	                    }  
	                    
	                    System.out.print("\n\nPrefix Array: ");
	    	            for(int o = 0; o <= prefixSize; o++){
	    	                System.out.print(prefixArray[o] + " ");
	    	            }
	    	            
	    	            System.out.println(" ");
	    	            System.out.print("Prefix String: ");
	    	            for(int o = 0; o < prefixStringSize; o++){
	    	                System.out.print(prefixString[o] + " ");
	    	            }
	    	            System.out.println("");	 
	                    break;
	                    
	                    
	                    
	                case ')':
	                case '(':
	                	operatorVal = revString[i];	
                        ++prefixSize;
                        prefixArray[prefixSize] = operatorVal;                                                 
                        System.out.print("\nPreFix Array: ");
        	            for(int o = 0; o <= prefixSize; o++){
        	                System.out.print(prefixArray[o]);
        	            }
        	            
        	            System.out.println(" ");
        	            System.out.print("PreFix String: ");
        	            for(int o = 0; o < prefixStringSize; o++){
        	                System.out.print(prefixString[o]);
        	            }
        	            System.out.println(" ");	 
                        
                        if(revString[i] == '(') {	                   
	                    int t = prefixSize;
	                    	while (t > -1){
		
	                    		if(prefixArray[t] == '(') {		                        	
	                    			prefixArray[prefixSize] = 0;
		                        	--prefixSize;                   	
		                        }		                        
		                        else if(prefixArray[t] == ')') {
		                        	prefixArray[prefixSize] = 0;
		                        	--prefixSize;    
		                        	break;
		                        }
		                        else{
									if(space) 
									{
										prefixString[prefixStringSize] = ' ';
										prefixString[++prefixStringSize] = prefixArray[prefixSize];
								        ++prefixStringSize;
		                                --prefixSize;
									}
									else {
		                        	prefixString[prefixStringSize] = prefixArray[prefixSize];
                                    ++prefixStringSize;
                                    --prefixSize;	    
									}
		                        }		                        
		                    t--;
		                    }   	                    		                                        
	                    }
	                break;	   
	                
	                
	                default:
	                	prefixString[prefixStringSize] = revString[i]; 
	                	++prefixStringSize;
	                    System.out.print("\nPreFix Array: ");
	    	            for(int o = 0; o <= prefixSize; o++){
	    	                System.out.print(prefixArray[o]);
	    	            }
	    	            
	    	            System.out.println(" ");
	    	            System.out.print("PreFix String: ");
	    	            for(int o = 0; o < prefixStringSize; o++){
	    	                System.out.print(prefixString[o]);
	    	            }
	    	            System.out.println(" ");	 
	                    
	                    break;
	            
	            }
	            
	                       
	        }	        
	        int d = prefixSize;       
			while(d > -1) {         	
				if(space) 
				{
					prefixString[prefixStringSize] = ' ';
					prefixString[++prefixStringSize] = prefixArray[prefixSize];
			        ++prefixStringSize;
                    --prefixSize;
				}
				else {
            	prefixString[prefixStringSize] = prefixArray[prefixSize];
                ++prefixStringSize;
                --prefixSize;	    
				}	
                d--;
            }              
	        System.out.print("\nPreFix Array: ");
	        for(int o = 0; o <= prefixSize; o++){
	            System.out.print(prefixArray[o]);
	        }
	        System.out.println(" ");
	        System.out.print("PreFix String: ");
	        for(int o = 0; o < prefixStringSize; o++){
	            System.out.print(prefixString[o]);	      
	        }
	        
	        char[] finalPrefix = new char[prefixString.length];
	        
			for (int b = prefixString.length-1, c = 0; b > -1; b--)
			{
				finalPrefix[c] = prefixString[b];
				c++;
			}
	        
	        //converts finalPrefix char array into string
			String finalPrefixString = new String(finalPrefix);
			
			//trims the finalPrefixString to remove unnecessary spaces
			finalPrefixString = finalPrefixString.trim();
			
	        System.out.println(" ");
	        
	        return finalPrefixString;
	    }
    	


        
    	    
    	    
        //Post fix//
	    static String PostFix(String m) {
	        
	        char[] postArray;
	        char[] postString;

	         
	        postArray = new char[m.length() + 100];
	        postString = new char[m.length() + 100];
	        
	        
	        String result = "";
	        int postSize = -1;
	        int postStringSize = 0;
	        
	        char operatorVal = 0;
	               	
	        System.out.println("\nScanned Character: " + m + "\n");

	        for (int i = 0; i < m.length(); i++) { 
	            char scanChar = m.charAt(i);
	            
	            switch (scanChar) {            
	                case '+':
	                case '-':
	                case '/':
	                case '*':
	                case '^':
	                	
	                    if (postSize == -1){
	                        operatorVal = scanChar;
	                    	++postSize;
	                        postArray[postSize] = operatorVal;	                        	                        
	                    }
	                    else{
	                        
	                        if ((precedence(postArray[postSize]) == precedence(scanChar)) || (precedence(postArray[postSize]) > precedence(scanChar))){	                                                       
	                        		int d = postSize ;       
	                        			while(d > -1) {
	                                    	
	                                    	if((precedence(postArray[postSize]) < precedence(scanChar))) {		                                    	
		                                    	break;		                                    	
		                                    }
	                                    	
	                                    	postString[postStringSize] = postArray[postSize];
		                                    ++postStringSize;
		                                    --postSize;	
		                                    d--;
	                                    }
	                        			operatorVal = scanChar;	
	                                    ++postSize;
	                                    postArray[postSize] = operatorVal;    
	                        }
	                        else if ((precedence(postArray[postSize]) < precedence(scanChar))){
	                        	operatorVal = scanChar;	
                                ++postSize;
                                postArray[postSize] = operatorVal;                                                      
	                        }
	                        
	                    }   	                    
	                    System.out.print("\nPost Array: ");
	    	            for(int o = 0; o <= postSize; o++){
	    	                System.out.print(postArray[o]);
	    	            }
	    	            
	    	            System.out.println(" ");
	    	            System.out.print("Post String: ");
	    	            for(int o = 0; o < postStringSize; o++){
	    	                System.out.print(postString[o]);
	    	            }
	    	            System.out.println(" ");	 
	                    break;
	                case ')':
	                case '(':
	                	operatorVal = scanChar;	
                        ++postSize;
                        postArray[postSize] = operatorVal;                                                 
                        System.out.print("\nPost Array: ");
        	            for(int o = 0; o <= postSize; o++){
        	                System.out.print(postArray[o]);
        	            }
        	            
        	            System.out.println(" ");
        	            System.out.print("Post String: ");
        	            for(int o = 0; o < postStringSize; o++){
        	                System.out.print(postString[o]);
        	            }
        	            System.out.println(" ");	 
                        
                        if(scanChar == ')') {	                   
	                    int t = postSize;
	                    	while (t > -1){
		
	                    		if(postArray[t] == ')') {		                        	
		                        	postArray[postSize] = 0;
		                        	--postSize;                   	
		                        }		                        
		                        else if(postArray[t] == '(') {
		                        	postArray[postSize] = 0;
		                        	--postSize;    
		                        	break;
		                        }
		                        else{
									if(space) 
									{
										postString[postStringSize] = ' ';
										postString[++postStringSize] = postArray[postSize];
										++postStringSize;
	                                    --postSize;	  
									}
									else 
									{    
										postString[postStringSize] = postArray[postSize];
										++postStringSize;
										--postSize;	
									}
		                        }		                        
		                    t--;
		                    }   	                    		                                        
	                    }
	                break;	                
	                default:
	                    postString[postStringSize] = scanChar; 
	                    postStringSize++;
	                    System.out.print("\nPost Array: ");
	    	            for(int o = 0; o <= postSize; o++){
	    	                System.out.print(postArray[o]);
	    	            }
	    	            
	    	            System.out.println(" ");
	    	            System.out.print("Post String: ");
	    	            for(int o = 0; o < postStringSize; o++){
	    	                System.out.print(postString[o]);
	    	            }
	    	            System.out.println(" ");	 
	                    
	                    break;
	            
	            }
	            
	                       
	        }	        
	        int d = postSize ;       
			while(d > -1) {         	
				if(space) 
				{
					postString[postStringSize] = ' ';
					postString[++postStringSize] = postArray[postSize];
					++postStringSize;
                    --postSize;	  
				}
				else 
				{    
					postString[postStringSize] = postArray[postSize];
					++postStringSize;
					--postSize;	
				}
                d--;
            }              
	        System.out.print("\nPost Array: ");
	        for(int o = 0; o <= postSize; o++){
	            System.out.print(postArray[o]);
	        }
	        System.out.println(" ");
	        System.out.print("Post String: ");
	        for(int o = 0; o < postStringSize; o++){
	            System.out.print(postString[o]);
	            result += postString[o];
	        }
	        System.out.println(" ");
	        return result;
	    }
  

}


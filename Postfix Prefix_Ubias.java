package PostfixAndInfix;

import java.util.Scanner;

public class PostAndInfix {

		public static Scanner userInput = new Scanner (System.in);
		public static String sds = "";
	    boolean exit = false;
		
		static int precedence(char c){ 
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

	    public static void main(String[] args){
	    	System.out.print("\nEnter Infix Notation: ");
	    	sds = userInput.nextLine();	    	
	    	infixValidation();   	
	        System.out.println("1. Prefix Notation  ");
	        System.out.println("2. Postfix Notation ");
	        System.out.println("3. EXIT             ");
	        
	        System.out.print("\nEnter desired option: ");
	        int select = userInput.nextInt();
	        
	        if (select == 1 ){
	            System.out.println("\nFinal Reversed Prefix Expression: " + PreFix(sds));
	        }else if (select == 2 ){
	            System.out.println("\nPostfix Expression: " + PostFix(sds));
	        }else if (select == 3 ){
	            System.out.println("Programmers: ");
	        }
	        
	        
	    }

	    //Postfix//
	    static String PostFix(String m) {
	        
	        char[] postArray;
	        char[] postString;

	         
	        postArray = new char[m.length()];
	        postString = new char[m.length()];
	        
	        
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
	    	            
	    	            System.out.println("");
	    	            System.out.print("Post String: ");
	    	            for(int o = 0; o < postStringSize; o++){
	    	                System.out.print(postString[o]);
	    	            }
	    	            System.out.println("");	 
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
        	            
        	            System.out.println("");
        	            System.out.print("Post String: ");
        	            for(int o = 0; o < postStringSize; o++){
        	                System.out.print(postString[o]);
        	            }
        	            System.out.println("");	 
                        
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
		                        	postString[postStringSize] = postArray[postSize];
                                    ++postStringSize;
                                    --postSize;	        	
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
	    	            
	    	            System.out.println("");
	    	            System.out.print("Post String: ");
	    	            for(int o = 0; o < postStringSize; o++){
	    	                System.out.print(postString[o]);
	    	            }
	    	            System.out.println("");	 
	                    
	                    break;
	            
	            }
	            
	                       
	        }	        
	        int d = postSize ;       
			while(d > -1) {         	
            	postString[postStringSize] = postArray[postSize];
                ++postStringSize;
                --postSize;	
                d--;
            }              
	        System.out.print("\nPost Array: ");
	        for(int o = 0; o <= postSize; o++){
	            System.out.print(postArray[o]);
	        }
	        System.out.println("");
	        System.out.print("Post String: ");
	        for(int o = 0; o < postStringSize; o++){
	            System.out.print(postString[o]);
	            result += postString[o];
	        }
	        System.out.println("");
	        return result;
	    }
	       
	    
	    
	    
	    //Prefix//
	    static String PreFix(String p){ 
	    	int charHolder = p.length();
	        char[] temp1 = new char[charHolder];
	        
	        for (int i = 0; i < charHolder; i++) {
	            temp1[charHolder - i - 1] = p.charAt(i);	
	         
	        }
	        System.out.print("Reversed Infix: ");
	        for(int c = 0; c < temp1.length; c++) {
	        	
	        	System.out.print(temp1[c]);
	        	
	        }
	        System.out.print("\n");
	    	
	    	char[] prefixArray; 
	        char[] prefixString; 
	         
	        prefixArray = new char[p.length()];
	        prefixString = new char[p.length()];
	        
	        
	        String result = "";
	        int prefixSize = -1;
	        int prefixStringSize = 0;
	        
	        char operatorVal = 0;
	               	
	        System.out.println("\nScanned Character: " + p + "\n");

	        for (int i = 0; i < p.length(); i++) { 
	            char scanChar = p.charAt(i); 
	            
	            switch (scanChar) {             
	                case '+':
	                case '-':
	                case '/':
	                case '*':
	                case '^':	                	
	                    if (prefixSize == -1){ 
	                        operatorVal = scanChar;
	                    	++prefixSize;
	                        prefixArray[prefixSize] = operatorVal;	                        	                        
	                    }
	                    else{	                        
	                        if ((precedence(prefixArray[prefixSize]) > precedence(scanChar))){ 	                                                
	                        		int d = prefixSize ;       
	                        			while(d > -1) {
	                                    	
	                                    	if((precedence(prefixArray[prefixSize]) < precedence(scanChar))) {		                                    	
		                                    	break;		                                    	
		                                    }
	                                    	
	                                    	prefixString[prefixStringSize] = prefixArray[prefixSize];
		                                    ++prefixStringSize;
		                                    --prefixSize;	
		                                    d--;
	                                    }
	                        			operatorVal = scanChar;	
	                                    ++prefixSize;
	                                    prefixArray[prefixSize] = operatorVal;    
	                        }
	                        else if ((precedence(prefixArray[prefixSize]) == precedence(scanChar)) || (precedence(prefixArray[prefixSize]) < precedence(scanChar))){	                        	
	                        	operatorVal = scanChar;	
                                ++prefixSize;
                                prefixArray[prefixSize] = operatorVal;                                                      
	                        }	                        
	                    }   	                    
	                    System.out.print("\nPrefix Array: ");
	    	            for(int o = 0; o <= prefixSize; o++){
	    	                System.out.print(prefixArray[o]);
	    	            }
	    	            
	    	            System.out.println("");
	    	            System.out.print("Prefix String: ");
	    	            for(int o = 0; o < prefixStringSize; o++){
	    	                System.out.print(prefixString[o]);
	    	            }
	    	            System.out.println("");	 
	                    break;
	                case ')': 
	                case '(':
	                	operatorVal = scanChar;	
                        ++prefixSize;
                        prefixArray[prefixSize] = operatorVal;                                                 
                        System.out.print("\nPrefix Array: ");
        	            for(int o = 0; o <= prefixSize; o++){
        	                System.out.print(prefixArray[o]);
        	            }
        	            
        	            System.out.println("");
        	            System.out.print("Prefix String: ");
        	            for(int o = 0; o < prefixStringSize; o++){
        	                System.out.print(prefixString[o]);
        	            }
        	            System.out.println("");	 
                        
                        if(scanChar == '(') {	                   
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
		                        	prefixString[prefixStringSize] = prefixArray[prefixSize];
                                    ++prefixStringSize;
                                    --prefixSize;	        	
		                        }		                        
		                    t--;
		                    }   	                    		                                        
	                    }
	                break;	                
	                default:
	                    prefixString[prefixStringSize] = scanChar;
	                    prefixStringSize++;
	                    System.out.print("\nPrefix Array: ");
	    	            for(int o = 0; o <= prefixSize; o++){
	    	                System.out.print(prefixArray[o]);
	    	            }
	    	            
	    	            System.out.println("");
	    	            System.out.print("Prefix String: ");
	    	            for(int o = 0; o < prefixStringSize; o++){
	    	                System.out.print(prefixString[o]);
	    	            }
	    	            System.out.println("");	 
	                    
	                    break;	            
	            }
                       
	        }	        
	        int d = prefixSize ;       
			while(d > -1) {         	
            	prefixString[prefixStringSize] = prefixArray[prefixSize];
                ++prefixStringSize;
                --prefixSize;	
                d--;
            }              
	        System.out.print("\nPrefix Array: ");
	        for(int o = 0; o <= prefixSize; o++){
	            System.out.print(prefixArray[o]);
	        }
	        System.out.println("");
	        System.out.print("Prefix String: ");
	        for(int o = 0; o < prefixStringSize; o++){
	            System.out.print(prefixString[o]);
	            result += prefixString[o];
	        }
	        System.out.println("");
	        return result;
	    }
	    
        static void infixValidation() {
        	
        	int spaceCounter = 0;
    		int cPc = 0;
    		int oPc = 0;
    		int operatorCounter = 0;
    		int operandCounter = 0;
    		int starter = 0;
    		
    		char[] chars = sds.toCharArray();   		
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
    				
    				}  				
    			if(spaceCounter == 2)		
    				{
    					System.out.println("\n==Infix Notation must not have Multiple Spaces==");
    					main(null);
    				}   			
    			if(operatorCounter == 2) 									  
    				{    				
    					System.out.println("\nInfix Notation must not have Multiple Operator==");
    					main(null);   			
    				}    			
    			if(operandCounter == 2)	  
    				{
    					System.out.println("\n==Infix Notation must not have Multiple Operand==");
    					main(null);
    				}  			    			
    			if(starter == 0)
                {
                    System.out.println(starter);
    				System.out.println("\n==Infix Notation Must Start with an Operand==");
                    main(null);
                }		
    		}
    	
    		if(oPc != cPc)    					  
    			{	
    				System.out.println("\nInsufficient Amount of Perenthesis");    			
    			}	
    	}
             
   	
}
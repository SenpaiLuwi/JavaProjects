package labActivity4;

import java.util.Scanner;

public class BSIT_2__Colonia_David_infix {
	
	static Scanner input = new Scanner(System.in);
	static String infix;
	static String splitElements[], operatorStack[], stringStack[];
	static Integer elementPrecedence[], operatorPrecedenceStack[];
			
	static Integer size, operandCount, operatorCount, openParentheses, closeParentheses, nonOpSymbol, elementInParentheses, stackInitial;
	static boolean isValid = false, isEmpty;
	
	public static void main(String[] args) {
		
		while(!isValid) {
			
			System.out.print("Input Infix Notation: ");
			infix = input.nextLine();
			
			infixInput(infix);
			
			System.out.println(infixValidation(splitElements) + "\n");
			//printForDebugging();
		}
		//postfix();
	}
	
	
	static void infixValueInitialization() {
		operandCount=0;
		operatorCount=0;
		openParentheses=0;
		closeParentheses=0;
		nonOpSymbol=0;
		elementInParentheses=0;
	}
	
	static void infixInput(String infix) {
		
		splitElements = infix.split(" ");
		size = splitElements.length;
		elementPrecedence = new Integer[size];
		
		infixValueInitialization();
		
		for(int i = 0; i < size; i++) {
			elementPrecedence[i] = assignPrecedence(splitElements[i]);
		}
		
		parenthesesChecker(splitElements, elementPrecedence);
		operatorStackInitialize();
		stringStackInitialize();
	}
	
	static String infixValidation(String[] splitElements) {
		String validation="";
		for(int i = 0; i < size; i++) {
			try {
				if((splitElements[0].matches("^[- +  * / ^]+$")) // checks if input is prefixed
						|| (splitElements[size-1].matches("^[- +  * / ^]+$")) // checks if input is postfixed
						|| (elementPrecedence[i] % 2 == 0 && elementPrecedence[i+1] % 2 != 1 && elementPrecedence[i+1] == 7)
						|| (elementPrecedence[i] % 2 != 1 && elementPrecedence[i+1] % 2 == 0 && elementPrecedence[i] == 7)
						|| ((elementInParentheses < 2 && elementInParentheses !=0)
						   || (elementInParentheses % 3 != 0)
						   && (elementInParentheses !=0) ) // checks if amount of elements in parentheses are valid
						|| (operatorCount >= operandCount) // checks if operators are more than number of operands
						|| (operatorCount < operandCount-1) // checks if operators are less than expected number
						|| (nonOpSymbol > 0) // checks if there are any non-operator symbols
						|| (openParentheses != closeParentheses) // checks if parentheses in input are paired
						){
							validation = "Input is Invalid";
							isValid = false;
							break;
						}
						else {
							validation = "Input is Valid";
							isValid = true;
						}
			}
			catch (NullPointerException e) {
				validation = "Input is Invalid";
			}
		}
		return validation;
	}
	
	static Integer assignPrecedence(String element) {
		switch(element) {
		case "+":
		case "-":
			operatorCount += 1;
			return 2;
		case "*":
		case "/":
			operatorCount += 1;
			return 4;
		case "^":
			operatorCount += 1;
			return 6;
		case "(":
			openParentheses += 1;
			return 7;
		case ")":
			closeParentheses += 1;
			return 7;
		default:
			if (element.matches("\\w*")) {
				operandCount += 1;
				return 1;
			} 
			else {
				nonOpSymbol += 1;
				return null;
			}
		}
	}
	
	static void parenthesesChecker(String[] splitElements, Integer[] elementPrecedence) {
		
		for(int firstParenthesis = 0; firstParenthesis < size; firstParenthesis++) {
			if(splitElements[firstParenthesis].equals("(") && firstParenthesis != 0) {
				for(int secondParenthesis = firstParenthesis + 1; secondParenthesis < size; secondParenthesis++) {
					if(splitElements[secondParenthesis].equals(")")) {
						break;
					}
					else {
						elementPrecedence[secondParenthesis]+=10;
						elementInParentheses+=1;
					}
				}
			}
		}
		
	}	
}
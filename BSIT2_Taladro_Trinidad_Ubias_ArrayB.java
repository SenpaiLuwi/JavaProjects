package FileHandling1;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class FileHandling1 
{
	static DecimalFormat df = new DecimalFormat ("#00.00");
	static Scanner input = new Scanner(System.in);
	static PrintWriter outputFile;

	static int studGrade, quizGrade, studpassed, studfailed, menuInput, studNumber;
	static double gradeScore[][], gradeDelete[][], gradeAverage[];
	static boolean loopProgram = true, YesNoLoop = true;
	static String YesNoInput, Graderemarks[];

	
	public static void main(String[] args)
	{
		
		System.out.println("\nFile Handling of the Students:");
		
				System.out.println("\nWould You like to Grade your Students? \n");
				System.out.println("Yes:");
				System.out.println("No: \n");
	
				while(YesNoLoop)
				{
					System.out.print("Y|N: ");
					YesNoInput = input.nextLine();
					
					
					if (YesNoInput.equals("Y") || YesNoInput.equals("y"))
					{
						YesNoLoop = false;
					}
					
					else if (YesNoInput.equals("N") || YesNoInput.equals("n"))
					{
						
						System.out.print("Program Canceled! Program coded by Ubias, Taladro, Trinidad | 2BSIT-2");
						System.exit(0);
						
					}
					
					else
						System.out.println("\nError, invalid input.");
				
		
				}
				
		try 
		{			
			userInput();		
			while(loopProgram == true) 
			{
				outputFile = new PrintWriter("../DSA/src/FileHandling1/Student.txt");
				mainMenu();
				printNotepad();
			}
		}
		catch(FileNotFoundException x) 
		{
			System.out.println("This file Cannot be Found!");
		}
		finally 
		{
			outputFile.close();
			System.exit(0);
		}
	}
	
	static void mainMenu() 
	{
		System.out.println("\n\nMain Menu:");
		System.out.println("1. View Grade Book");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Exit Program");
		
		System.out.print("\nEnter Input 1-4: ");
		menuInput = input.nextInt();
		
		switch(menuInput) 
		{
			case 1:
				System.out.println("\nView Menu:");
				viewStudent();
				break;
			case 2:
				System.out.println("Update Menu:");
				updateStudent();
				break;
			case 3:
				System.out.println("Delete Menu:");
				deleteStudent();
				break;
			case 4:
				System.out.println("Program Terminated! Program coded by  Taladro, Trinidad, Ubias,| 2BSIT-2");
				loopProgram = false;
				break;
			default:
				System.out.println("\nInvalid Input please input the exact numbers!");
		}
	}
	
	
	
static void averageView() 
	{
		gradeAverage = new double[studGrade];
		
		for(int row = 0; row < studGrade; row++) 
		{		
			double sum = 0;
			for(int col = 0; col < quizGrade; col++) 
			{
				sum += gradeScore[row][col];
			}
			if(row>0) 
			{
				gradeAverage[row] = sum/quizGrade;
			}
		}
	}


	//VIEW CONSOLE//
static void viewStudent()
		{
			System.out.print("\t");
			for(int printRow = 0; printRow < studGrade; printRow++) 
			{
				
				if(printRow > 0 && gradeAverage[printRow] >= 0) 
				{
					System.out.print("Student #" + (printRow));
				}
				
				else 
				{
					outputFile.print("");
				}
				
				for(int printCol = 0; printCol < quizGrade; printCol++) 
				{
					if(printRow == 0) 
					{
						System.out.print("\tQuiz " + (printCol+1));
					}		
					
					else 
					{
						System.out.print("\t" + df.format(gradeScore[printRow][printCol]));
					}
				}
				
				if(printRow==0) 
				{
					System.out.print("\tAverage\t" + "Remarks\n");
				}
				
				else 
				{
					System.out.print("\t" + df.format(gradeAverage[printRow]) + "\t" + Graderemarks[printRow]+ "\n");
				}
				
			}
			System.out.println("\nNumber of students passed: " + studpassed);
			System.out.println("Number of students failed: " + studfailed);
		}
		

	//PRINT FOR NOTEPAD//
static void printNotepad()
		{
			outputFile.print("\t");
			for(int printRow = 0; printRow < studGrade; printRow++)
			{
				if(printRow > 0) 
				{
					outputFile.print("Student #" + (printRow));
				}
				
				for(int printCol = 0; printCol < quizGrade; printCol++) 
				{
					if(printRow == 0) 
					{
						outputFile.print("\tQuiz " + (printCol+1) + "\t");
					}
					else 
					{
						outputFile.print("\t" + df.format(gradeScore[printRow][printCol]) + "\t");
					}
				}
				
				if(printRow==0) 
				{
					outputFile.print("\tAverage\t" + "\tRemarks\t\n");
				}
				else 
				{
					outputFile.print("\t" + df.format(gradeAverage[printRow]) + "\t" + "\t" + Graderemarks[printRow] + "\t"  + "\n");
				}	
			}
			outputFile.println("\nNumber of students passed: " + studpassed);
			outputFile.println("Number of students failed: " + studfailed);
		}
		
		
		
		
		
		
static void remarkGrade() 
		{
			Graderemarks = new String[studGrade];
			studpassed=0;
			studfailed=0;
			
			for(int rmkrow = 0; rmkrow < studGrade; rmkrow++) 
			{
				if(gradeAverage[rmkrow] >= 75 && rmkrow > 0) 
				{
					studpassed++;
					Graderemarks[rmkrow] = "Passed";
				}
				else if(gradeAverage[rmkrow] < 75 && rmkrow > 0)
				{
					studfailed++;
					Graderemarks[rmkrow] ="Failed";
				}
			}
		}
		
	
	// UPDATE //
static void userInput() 
		{
			System.out.print("Number of Students: ");
			studGrade = input.nextInt();
			studGrade+=1;
			
			System.out.print("Number of Quizzes: ");
			quizGrade = input.nextInt();
			
			gradeScore = new double[studGrade][quizGrade];
			gradeDelete = new double[studGrade][quizGrade];
			
			for(int insRow = 0; insRow < studGrade; insRow++) 
			{
				double quizScore = 0.00;	
				if(insRow > 0) 
				{
					System.out.println("\nStudent #" + insRow);
					for(int insertCol = 0; insertCol < quizGrade; insertCol++) 
					{
						System.out.print("Quiz " + (insertCol+1) + ":\t\t");
						quizScore = input.nextDouble();
						gradeScore[insRow][insertCol] = quizScore;
						gradeDelete[insRow][insertCol] = quizScore;
					}
					
					averageView();
					remarkGrade();
					
					System.out.println("Average:\t" + df.format(gradeAverage[insRow]));
					System.out.println("Remarks:\t" + Graderemarks[insRow]);
				}
			}
			
			System.out.println("\nNumber of students passed: " + studpassed);
			System.out.println("Number of students failed: " + studfailed);
		}



//INPUT FOR THE UPDATE//
static void updateStudent() 
	{
		System.out.print("Input Student Number: ");
		studNumber = input.nextInt();
	
		double quizScore = 0.00;
		if(studNumber > 0 && studNumber < studGrade) 
		{
			System.out.println("\nStudent #" + studNumber);
			for(int inpCol = 0; inpCol < quizGrade; inpCol++) 
			{
				
				System.out.print("Quiz " + (inpCol+1) + ":\t\t");
				quizScore = input.nextDouble();
				gradeScore[studNumber][inpCol] = quizScore;
				gradeDelete[studNumber][inpCol] = quizScore;
			}
				averageView();
				remarkGrade();
				
				System.out.println("Average:\t" + df.format(gradeAverage[studNumber]));
				System.out.println("Remarks:\t" + Graderemarks[studNumber]);
				
				System.out.println("\nNumber of students passed: " + studpassed);
				System.out.println("Number of students failed: " + studfailed);
			}
		else 
		{
			System.out.println("\nRecord not Found");
		}
	}
		
//DELETE//
static void deleteStudent() 
{
	System.out.print("Input Student Number: ");
	studNumber = input.nextInt();
	
	if(studNumber > 0 && studNumber < studGrade && gradeAverage[studNumber] >= 0) 
	{ 
		for(int deleteCol = 0; deleteCol < quizGrade; deleteCol++) 
		{
			gradeDelete[studNumber][deleteCol] = 0 ;
		}
		
		gradeScore = new double[studGrade][quizGrade];
		
		for(int newRow = 0; newRow < studGrade; newRow++) 
		{
			for(int newCol = 0; newCol < quizGrade; newCol++) 
			{
				
				gradeScore[newRow][newCol] = gradeDelete[newRow][newCol];
			}
		}
		
		averageView();
		remarkGrade();
		
		System.out.println("The Student " + studNumber + " Record Has Been Deleted!");
	}
	else 
	{
		System.out.println("\nRecord not Found"); 
	}
	
}
}


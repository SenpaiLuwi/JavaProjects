package Act4;

import java.util.Scanner;

public class Act4 {
    
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter student name: ");
			String name = input.nextLine().toUpperCase();

			System.out.print("Enter grade in English: ");
			double englishGrade = input.nextDouble();

			System.out.print("Enter grade in Math: ");
			double mathGrade =  input.nextDouble();
			
			System.out.print("Enter grade in Science: ");
			double scienceGrade = input.nextDouble();
			
			System.out.print("Enter grade in History: ");
			double historyGrade =  input.nextDouble();
			
			System.out.print("Enter grade in PE: ");
			double peGrade = input.nextDouble();

			displayStudentName(name);
			double average = calculateAverage(englishGrade, mathGrade, scienceGrade, historyGrade, peGrade);
			displayRemarks(average);
			countPassedFailed(englishGrade, mathGrade, scienceGrade, historyGrade, peGrade);
		}
        
    }
    
    public static void displayStudentName(String name) {
        System.out.println("");
        System.out.println("");
        System.out.println("Student Name: " + name);
    }
    
    public static double calculateAverage(double englishGrade, double mathGrade, double scienceGrade, double historyGrade, double peGrade) {
    	double sum = englishGrade + mathGrade + scienceGrade + historyGrade + peGrade;
        double average = sum / 5;
        System.out.println("The average grade is: " + average);
        return average;
    }
    
    public static void displayRemarks(double average) {
        if (average >= 95 && average <= 100) {
            System.out.println("Remarks: Excellent");
        } else if (average >= 90 && average <= 94) {
            System.out.println("Remarks: Very Good");
        } else if (average >= 85 && average <= 89) {
            System.out.println("Remarks: Good");
        } else if (average >= 75 && average <= 84) {
            System.out.println("Remarks: Passed");
        } else {
            System.out.println("Remarks: Failed");
        }
    }
    
    public static void countPassedFailed(double englishGrade, double mathGrade, double scienceGrade, double historyGrade, double peGrade) {
        int numPassed = 0;
        int numFailed = 0;
        if (englishGrade >= 75) {
            numPassed++;
        } else {
            numFailed++;
        }
        if (mathGrade >= 75) {
            numPassed++;
        } else {
            numFailed++;
        }
        if (scienceGrade >= 75) {
            numPassed++;
        } else {
            numFailed++;
        }
        if (historyGrade >= 75) {
            numPassed++;
        } else {
            numFailed++;
        }
        if (peGrade >= 75) {
            numPassed++;
        } else {
            numFailed++;
        }
        System.out.println("Number of subjects passed: " + numPassed);
        System.out.println("Number of subjects failed: " + numFailed);
    }
    
}

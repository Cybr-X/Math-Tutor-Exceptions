package Labs;
import java.util.*;

/*Xavier White
 * 3/18/2022
 * CSCI 1302
 * Lab 6
 * This lab is designed to find exceptions within the math tutor program.
 * The program throws exceptions for division by 0, a negative difference, and Input Mismatch.
 */


public class Lab6 {

	//Addition Method
	public static int addition(int num1, int num2, Scanner answer) {


		System.out.println(num1 +" + "+num2+"?");

		int addingInput = answer.nextInt();


		if (addingInput == (num1 + num2)) {

			System.out.println("Correct!");
		}

		else {

			System.out.println("Your answer is wrong. The correct answer is "+ (num1 + num2));
		}

		return (num1 + num2);
	}

	//Subtraction Method
	public static int subtraction(int num1, int num2, Scanner answer) throws Exception{

		if(num1 < num2) 

			throw new Exception("Num1 is less than Num2");

		System.out.println(num1 +" - "+ num2 +"?");

		int subInput = answer.nextInt();


		if (subInput == (num1-num2)) {

			System.out.println("Correct!");
		}

		else {
			System.out.println("Your answer is wrong. The correct answer is "+ (num1-num2));
		}
		return num1-num2;

	}

	//Multiplication Method
	public static int multiplication(int num1, int num2, Scanner answer){


		System.out.println(num1 +" * "+num2+"?");

		int multInput = answer.nextInt();

		if (multInput == num1 * num2) {

			System.out.println("Correct!");
		}

		else {

			System.out.println("Your answer is wrong. The correct answer is "+ (num1 * num2));
		}

		return num1 * num2;


	}

	//Division Method
	public static int division(int num1, int num2, Scanner answer) throws Exception {

		if (num2 == 0) 
			throw new Exception("Cannot Divide by Zero");

		System.out.println(num1 +" / "+ num2+"?");
		double divInput = answer.nextDouble();



		if (divInput == (num1/num2)) {
			System.out.println("Correct!");
		}

		else {
			System.out.println("Your answer is wrong. The correct answer is "+ (num1/num2));
		}

		return num1/num2;


	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Display Main Menu
		System.out.println("Main menu");

		System.out.println("1: Addition");

		System.out.println("2: Subtraction");

		System.out.println("3: Multiplication");

		System.out.println("4: Division");

		System.out.println("5: Exit");

		int userChoice;

		//Prompt User to Enter Main Menu Choice
		try {System.out.println("Enter a choice:");

		userChoice = input.nextInt();

		Scanner answer = new Scanner(System.in);

		while (userChoice != 5) {

			int firstNum = (int)(Math.random()* 100);

			int secondNum = (int)(Math.random()* 100);


			switch (userChoice) {


			case 1:

				addition(firstNum,secondNum, answer);

				break;

			case 2:

				try {
					subtraction(firstNum,secondNum, answer);
				}
				catch(Exception sx) {
					System.out.println("Arithmetic Error in " + firstNum + " - " + secondNum + ". " + " The second number " +secondNum + " is greater than the first number " + firstNum);
				}

				break;

			case 3:

				multiplication(firstNum, secondNum, answer);

				break;

			case 4:
				try {
					division(firstNum,secondNum,answer);
				}
				catch(Exception ex) {
					System.out.println("Arithmetic Exception: The integer " + firstNum + " is not divisible by " + secondNum);
				}


				break;

			case 5:

				System.exit(0); break;

			default:

				System.out.println("Error: Out of range");
				System.out.println("Refresh the program to try again");

				System.exit(0);

			}

			System.out.println("Enter a choice:");

			userChoice = input.nextInt();

		}

		System.out.println("Thank you for using the Math Tutor Program. Have a Great Day!");
		input.close();
		answer.close();

		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Exception: Refresh the program and only use integers for the menu and for your answers.");
		}


	}
}


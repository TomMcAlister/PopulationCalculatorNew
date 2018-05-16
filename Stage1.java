//Created by Tom McAlister - u3187811
//Date created - 8/4/18
//Date last modifed - 23/4/18
//Description - This is a console based application that will calculate eitehr decay or growth of a fixed or variable rate
package u3187811.tom.com;

import java.util.Scanner;

public class Stage1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Setting the scanner
		Scanner inConsole = new Scanner(System.in);
		
		char option;
		
		//Checking if its fixed or variable growth/decay
		System.out.println("Is the growth rate fixed or variable? Type F or fixed and V for variable.");
		option = inConsole.next().charAt(0);
		
		
		if((option == 'V') || (option == 'v')) {
			Variable();
		} else if((option == 'F') || (option == 'f')) {
			Fixed();
		}
	}
	//function for variable maths
	static void Variable()	{
	Scanner inConsole = new Scanner(System.in);
	
	double[] gRates = new double[10];
	double ans = 0;
	
	float growth, pop, died = 0;
	int n = 0;

	System.out.println("What is the starting population?");
	pop = inConsole.nextInt();
	
	for(int i = 0; i < 10; i++) {     
		n++;
		System.out.println("What is the growth rate for gen " + n + "? (%)");
		gRates[i] = inConsole.nextInt();	
	}
	
	
	for(int d = 0; d < 10; d++) {
	pop = (int)pop;
	gRates[d]=gRates[d]/100 + 1;
	pop *= gRates[d];
	
}
	if(pop > 5000) {
		died = pop - 5000;
		pop = 5000;
	}
	System.out.println("There are " + (int)pop + " fish and " + (int)died + " died due to overpopulation");
	main(null);
	
}
	//Function for static maths
	static void Fixed() {
		Scanner inConsole = new Scanner(System.in);
		
		int pop, gens, died = 0;
		double iRate;
		System.out.println("What is the starting population?");
		pop = inConsole.nextInt();
		
		System.out.println("What is the growth rate? (%)");
		iRate = inConsole.nextInt();
		
		System.out.println("How many generations?");
	    gens = inConsole.nextInt();
				
			//float increase = (float)Math.pow(1+iRate/100, gens);
			//pop = Fpop * increase;
		iRate = iRate/100;	
		iRate = iRate + 1;
	    
			for(int i = 0; i < gens; i++) {
				pop = (int)pop;
				pop *= iRate;
			}
			
		
			if(pop > 5000) {
				died = pop - 5000;
			}
			System.out.println("There are " + (int)pop + " fish and " + (int)died + " died due to overpopulation");
			
		System.out.println(pop);
		main(null);
	}
}

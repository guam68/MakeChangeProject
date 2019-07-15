package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double paid, cost;
		boolean isRunning = true;

		while(isRunning){
			System.out.println("\nEnter the cost: ");
			cost = scanner.nextDouble();
			System.out.println("Enter the amount paid: ");
			paid = scanner.nextDouble();

			int pennies = getPennies(paid, cost);
			if (pennies == -1){
				System.out.println("Not enough money");
			} else {
				printChange(pennies);
			}

			System.out.print("\nEnter [q] to quit or any key to continue: ");
			String quit_char = scanner.next();

			isRunning = quit_char.equals("q") ? false : true;
		}
		
		scanner.close();
	}

	public static int getPennies(double paid, double cost) {
		int pennies = (int) (paid * 100 - cost * 100);
		if (pennies < 0) {
			return -1;
		} else {
			return pennies;
		}
	}

	public static void printChange(int tot_pennies) {
		int dollar = tot_pennies / 100; 
		int cent = tot_pennies % 100;
		double centF = cent / 100.0;
		int twenty, ten, five;
		int quarter, dime, nickel;
		String change = "";

		if (dollar / 20 > 0) {
			twenty = dollar / 20;
			dollar -= 20 * twenty;
			change += "\n20s:\t\t" + twenty;
		}

		if (dollar / 10 > 0) {
			ten = dollar / 10;
			dollar -= 10 * ten;
			change += "\n10s:\t\t" + ten;
		}

		if (dollar / 5 > 0) {
			five = dollar / 5;
			dollar -= 5 * five;
			change += "\n5s:\t\t" + five;
		}

		if (dollar > 0 ) {
			change += "\n1s:\t\t" + dollar;
		}

		if (cent / 25 > 0) {
			quarter = cent / 25;
			cent -= 25 * quarter;
			change += "\nQuarters:\t" + quarter;
		}

		if (cent / 10 > 0) {
			dime = cent / 10;
			cent -= 10 * dime;
			change += "\nDimes:\t\t" + dime;
		}

		if (cent / 5 > 0) {
			nickel = cent / 5;
			cent -= 5 * nickel;
			change += "\nNickels:\t" + nickel;
		}

		if (cent > 0) {
			change += "\nPennies:\t" + cent;
		}

		System.out.println("--------------------------");
		System.out.println("\nYour change is " + (dollar + centF));
		System.out.println(change);
	}

}

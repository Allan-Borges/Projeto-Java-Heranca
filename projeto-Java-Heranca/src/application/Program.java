package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> listTaxPayer = new ArrayList<>();

		System.out.print("Enter the number of taz payers:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data: ");
			System.out.print("Individual or company (i/c)?");
			char op = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("AnualIncome: ");
			double anualIncome = sc.nextDouble();

			if (op == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditure = sc.nextDouble();

				Individual individual = new Individual(name, anualIncome, healthExpenditure);
				listTaxPayer.add(individual);
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployee = sc.nextInt();
				Company company = new Company(name, anualIncome, numberOfEmployee);
				listTaxPayer.add(company);
			}

		}

		System.out.println();
		System.out.println("TAXES PAID: ");

		for (TaxPayer taxpayer : listTaxPayer) {
			System.out.println(taxpayer);
		}

		double sum = 0.0;
		for (TaxPayer taxpayer : listTaxPayer) {
			sum += taxpayer.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
		sc.close();
	}

}

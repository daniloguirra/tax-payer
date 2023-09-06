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
		
		List<TaxPayer> list = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		
		for(int i = 1; i <= n; i++) {
			
			System.out.println("Tax payer " + i + " data: ");
			System.out.println();
			System.out.print("Individual or company (i/c)? ");
			char ic = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anuallncome = sc.nextDouble();
			
			if(ic == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpedintures = sc.nextDouble();
				
				Individual individual = new Individual(name, anuallncome, healthExpedintures);
				list.add(individual);
				
			}else if(ic == 'c') {
				System.out.print("Health expenditures: ");
				int numberOfEmployees = sc.nextInt();
				
				Company company = new Company(name, anuallncome, numberOfEmployees);
				list.add(company);
			}
			
		}
		
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID: ");
		
		for(TaxPayer taxpayer  : list) {
			double tax = taxpayer.tax();
			System.out.printf(taxpayer.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		
		sc.close();

	}

}

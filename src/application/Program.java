package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcelamento;
import services.ContractService;
import services.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Numero do Contrato: ");
		int number = sc.nextInt();
		System.out.print("DATA (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do Contrato: ");
		double totalValue = sc.nextDouble();
		
		Contrato contrato = new Contrato(number,date,totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int parcelas = sc.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		contractService.processContrato(contrato, parcelas);
		
		System.out.println(":::Parcelas:::");
		for(Parcelamento parcela : contrato.getParcelamentos()) {
			System.out.println(parcela);
		}
		
		
		
		
		sc.close();
	}

}

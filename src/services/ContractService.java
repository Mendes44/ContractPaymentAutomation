package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Parcelamento;

public class ContractService {

	//Como que essa classe depende da interface tenho que chamar a interface
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContrato(Contrato contrato, Integer months) {
	
		double basicQuota = contrato.getTotalValue() / months;
		
		for (int parcela = 1; parcela <= months; parcela++) {
			
			//Para calcular add o mês
			LocalDate dueDate = contrato.getDate().plusMonths(parcela);
			
			//Calcular o juros sobre o valor da quota ja dividido
			double juros = onlinePaymentService.juros(basicQuota, parcela);
			double taxa = onlinePaymentService.taxaPagamento(juros + basicQuota);
			double quota = basicQuota + juros + taxa;
			
			contrato.getParcelamentos().add(new Parcelamento(dueDate, quota));
		}
	}
}

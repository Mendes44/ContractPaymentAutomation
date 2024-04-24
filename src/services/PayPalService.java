package services;

public class PayPalService implements OnlinePaymentService{

	@Override
	public Double taxaPagamento(double amount) {
		return amount * 0.02;
	}

	@Override
	public Double juros(double amount, int months) {
		return amount * 0.01 * months;
	}
	
	

}

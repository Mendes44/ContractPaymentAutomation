package services;

public interface OnlinePaymentService  {

	Double taxaPagamento (double amount);
	Double juros (double amount, int months);
}

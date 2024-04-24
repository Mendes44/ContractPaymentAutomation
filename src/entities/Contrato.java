package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

	private int number;
	private LocalDate date;
	private Double totalValue;
	
	//Lista para indicar varios *
	private List<Parcelamento> parcelamentos = new ArrayList<>();
	
	public Contrato() {
	}
	
	public Contrato(int number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Double getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Parcelamento> getParcelamentos() {
		return parcelamentos;
	}
	
	//Em lista nao se da set por isso removi.	
	
}

package model.entities;

public class Invoice {
	
	private Double pagamentoBasico;
	private Double tax;
	
	public Invoice() {
		
	}
	public Invoice(Double pagamentoBasico, Double tax) {
		this.pagamentoBasico = pagamentoBasico;
		this.tax = tax;
	}
	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}
	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getPagamentoTotal() {
		
		return getPagamentoBasico() + getTax();
	}
	
	
	
	
	

}

package model.service;

import model.entities.AluguelCarro;
import model.entities.Invoice;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	private TaxService taxaServico;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxService taxaServico) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	public void processIvoice(AluguelCarro aluguelCarro) {
		
		long t1 = aluguelCarro.getInicio().getTime();
		long t2 = aluguelCarro.getFim().getTime();
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;

		double pagamentoBasico;
		
		if (hours <= 12.0) {
			pagamentoBasico =  Math.ceil(hours) * precoPorHora;

			
		}
		else {
			pagamentoBasico =  Math.ceil(hours / 24) * precoPorDia;
			
		}
		
		double tax = taxaServico.tax(pagamentoBasico);
		aluguelCarro.setInvoice(new Invoice(pagamentoBasico, tax));
	}
	
	
	

}

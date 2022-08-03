package model.service;

import model.entities.AluguelCarro;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	private TaxaServicoBrasil taxaServico;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServicoBrasil taxaServico) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	public void processIvoice(AluguelCarro aluguelCArro) {
		
		
		
	}
	
	
	

}

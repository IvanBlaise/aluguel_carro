package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.service.ServicoAluguel;
import model.service.TaxaServicoBrasil;


public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental data");
		System.out.println("Car model: ");
		String carModel = sc.nextLine();
		System.out.println("Pickup (dd/MM/yyyy hh:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.println("Return (dd/MM/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		AluguelCarro ac = new AluguelCarro(start, finish, new Veiculo(carModel));
		
		System.out.println("Enter price per hour: ");
		Double ph = sc.nextDouble();
		System.out.println("Enter price per day: ");
		Double pd = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(pd, ph, new TaxaServicoBrasil()); 
		
		servicoAluguel.processIvoice(ac);
		
		System.out.println("INVOICE: ");
		System.out.println("Basic payment: " + String.format("%.2f", ac.getInvoice().getPagamentoBasico()));
		System.out.println("Tax: " + String.format("%.2f", ac.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", ac.getInvoice().getPagamentoTotal()));
		
		
		
		
		
		
		sc.close();
		
		

	}

}

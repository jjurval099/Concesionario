package es.add.jurado_valdivia_unidad3;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCliente;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoDescuento;

@SpringBootApplication
public class JuradoValdiviaUnidad3Application implements CommandLineRunner
{
	@Autowired
	private IParseoDescuento iParseoDescuento;
	
	@Autowired
	private IParseoCliente iParseoCliente;

	public static void main(String[] args)
	{
		SpringApplication.run(JuradoValdiviaUnidad3Application.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception 
	{
		String rutaFicheroDescuento = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"descuento.csv";
		File fileDescuento = new File(rutaFicheroDescuento);
		Scanner scanner = new Scanner(fileDescuento);
		this.iParseoDescuento.parseoDescuento(scanner);
		
		String rutaFicheroCliente = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"cliente.csv";
		File fileCliente = new File(rutaFicheroCliente);
		Scanner scanner2 = new Scanner(fileCliente);
		this.iParseoCliente.parseoCliente(scanner2);
		
	}

}

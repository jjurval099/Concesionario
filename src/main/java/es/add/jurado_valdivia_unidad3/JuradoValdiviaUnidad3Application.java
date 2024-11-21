package es.add.jurado_valdivia_unidad3;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCliente;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoCocheNuevo;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoCocheViejo;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoDescuento;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoMecanico;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoReparar;

@SpringBootApplication
public class JuradoValdiviaUnidad3Application implements CommandLineRunner
{
	@Autowired
	private IParseoDescuento iParseoDescuento;
	
	@Autowired
	private IParseoCliente iParseoCliente;
	
	@Autowired
	private IParseoCocheViejo iParseoCocheViejo;
	
	@Autowired
	private IParseoCocheNuevo iParseoCocheNuevo;
	
	@Autowired
	private IParseoMecanico iParseoMecanico;
	
	@Autowired
	private IParseoReparar iParseoReparar;

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
		
		String rutaFicheroCocheViejo = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "cocheViejo.csv";
		File fileCocheViejo = new File(rutaFicheroCocheViejo);
		Scanner scannerCocheViejo = new Scanner(fileCocheViejo);
		this.iParseoCocheViejo.parseoCocheViejo(scannerCocheViejo);
		
		String rutaFicheroCocheNuevo = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "cocheNuevo.csv";
		File fileCocheNuevo = new File(rutaFicheroCocheNuevo);
		Scanner scannerCocheNuevo = new Scanner(fileCocheNuevo);
		this.iParseoCocheNuevo.parseoCocheNuevo(scannerCocheNuevo);
		scannerCocheNuevo.close();

		
		String rutaFicheroMecanico = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "mecanico.csv";
		File fileMecanico = new File(rutaFicheroMecanico);
		Scanner scannerMecanico = new Scanner(fileMecanico);
		this.iParseoMecanico.parseoMecanico(scannerMecanico);
		scannerMecanico.close();
		
		String rutaFicheroReparar = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "reparar.csv";
		File fileReparar = new File(rutaFicheroReparar);
		Scanner scannerReparar = new Scanner(fileReparar);
		this.iParseoReparar.parseoReparar(scannerReparar);
		scannerReparar.close();


		
	}

}

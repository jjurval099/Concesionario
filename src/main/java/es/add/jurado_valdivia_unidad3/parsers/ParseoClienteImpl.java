package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCliente;
import es.add.jurado_valdivia_unidad3.models.Cliente;
import es.add.jurado_valdivia_unidad3.models.Coche;
import es.add.jurado_valdivia_unidad3.models.Descuento;
import es.add.jurado_valdivia_unidad3.repository.ClienteRepository;
import es.add.jurado_valdivia_unidad3.repository.CocheRepositorio;
import es.add.jurado_valdivia_unidad3.repository.DescuentoRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;

@Service
public class ParseoClienteImpl implements IParseoCliente
{
	
	@Autowired
	private DescuentoRepository descuentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CocheRepositorio cocheRepository;

	@Override
	public void parseoCliente(Scanner scanner) throws ConcesionarioError
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Cliente cliente = new Cliente();
			
			cliente.setNif(valores[0]);
			
			cliente.setNombre(valores[1]);
			
			cliente.setApellidos(valores[2]);
			
			cliente.setDireccion(valores[3]);
			
			cliente.setTelefono(valores[4]);
			
			Optional<Descuento> optionalDescuento = this.descuentoRepository.findById(valores[5]);
			
			Optional<Coche> optionalCoche = this.cocheRepository.findById(valores[6]);
						
			this.clienteRepository.saveAndFlush(cliente);			 			
		}
		
	}

}

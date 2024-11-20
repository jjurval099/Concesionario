package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoDescuento;
import es.add.jurado_valdivia_unidad3.models.Cliente;
import es.add.jurado_valdivia_unidad3.models.Descuento;
import es.add.jurado_valdivia_unidad3.repository.ClienteRepository;
import es.add.jurado_valdivia_unidad3.repository.DescuentoRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;

@Service
public class ParseoDescuentoImpl implements IParseoDescuento
{
	
	@Autowired
	private DescuentoRepository descuentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void parseoDescuento(Scanner scanner) throws ConcesionarioError 
	{
		
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Descuento descuento = new Descuento();
			
			descuento.setAro(valores[0]);
			
			descuento.setImporte(Integer.valueOf(valores[1]));
			
			Optional<Cliente> optionalCliente = this.clienteRepository.findById(valores[3]);
			
			
			this.descuentoRepository.saveAndFlush(descuento);			 			
		}
		
	}

}

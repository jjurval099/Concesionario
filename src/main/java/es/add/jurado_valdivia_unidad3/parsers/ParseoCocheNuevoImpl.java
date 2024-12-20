package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCoche;
import es.add.jurado_valdivia_unidad3.interfaces.IParseoCocheNuevo;
import es.add.jurado_valdivia_unidad3.models.Cliente;
import es.add.jurado_valdivia_unidad3.models.Coche;
import es.add.jurado_valdivia_unidad3.models.CocheNuevo;
import es.add.jurado_valdivia_unidad3.repository.ClienteRepository;
import es.add.jurado_valdivia_unidad3.repository.CocheNuevoRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParseoCocheNuevoImpl implements IParseoCocheNuevo
{
	@Autowired
	private IParseoCoche iParseoCoche ;
	
    @Autowired
    private CocheNuevoRepository cocheRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void parseoCocheNuevo(Scanner scanner) throws ConcesionarioError {

        scanner.nextLine(); // Salta la línea inicial (cabecera)

        while (scanner.hasNext()) {
            String linea = scanner.nextLine();

            String[] valores = linea.split(",");

            // Crear el objeto CocheNuevo
            Coche coche = this.iParseoCoche.parseoCoche(valores) ;
            
            CocheNuevo cocheNuevo = new CocheNuevo(coche);
            
            cocheNuevo.setNUnidades(Integer.valueOf(valores[4]));

            // Buscar el cliente asociado por NIF
            Optional<Cliente> optionalCliente = clienteRepository.findById(valores[5]);

            if (!optionalCliente.isPresent())
            {
            	String errorString = "Cliente no encontrado con NIF: " + valores[5] ;
            	
            	log.error(errorString);
            	throw new ConcesionarioError(1, errorString) ;
            }
            	
            Cliente cliente = optionalCliente.get();

            // Asociar el coche con el cliente
            cocheNuevo.setIdCliente(cliente);

            // Guardar el coche en la base de datos
            cocheRepository.saveAndFlush(cocheNuevo);
        }
    }
}

package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCocheNuevo;
import es.add.jurado_valdivia_unidad3.models.CocheNuevo;
import es.add.jurado_valdivia_unidad3.models.Cliente;
import es.add.jurado_valdivia_unidad3.repository.ClienteRepository;
import es.add.jurado_valdivia_unidad3.repository.CocheNuevoRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParseoCocheNuevoImpl implements IParseoCocheNuevo {

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
            CocheNuevo cocheNuevo = new CocheNuevo();
            cocheNuevo.setMatricula(valores[0]);
            cocheNuevo.setMarca(valores[1]);
            cocheNuevo.setModelo(valores[2]);
            cocheNuevo.setColor(valores[3]);
            cocheNuevo.setNUnidades(Integer.valueOf(valores[4]));

            // Buscar el cliente asociado por NIF
            Optional<Cliente> optionalCliente = clienteRepository.findById(valores[5]);

            if (optionalCliente.isPresent()) {
                Cliente cliente = optionalCliente.get();

                // Asociar el coche con el cliente
                cocheNuevo.setIdCliente(cliente);

                // Guardar el coche en la base de datos
                cocheRepository.saveAndFlush(cocheNuevo);
            } else {
                log.error("Cliente no encontrado con NIF: " + valores[5]);
            }
        }
    }
}

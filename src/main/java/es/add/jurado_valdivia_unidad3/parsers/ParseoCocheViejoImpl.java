package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCocheViejo;
import es.add.jurado_valdivia_unidad3.models.CocheViejo;
import es.add.jurado_valdivia_unidad3.models.Cliente;
import es.add.jurado_valdivia_unidad3.repository.ClienteRepository;
import es.add.jurado_valdivia_unidad3.repository.CocheViejoRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParseoCocheViejoImpl implements IParseoCocheViejo {

    @Autowired
    private CocheViejoRepository cocheViejoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void parseoCocheViejo(Scanner scanner) throws ConcesionarioError {

        scanner.nextLine(); 

        while (scanner.hasNext()) {
            String linea = scanner.nextLine();
            String[] valores = linea.split(",");

            if (valores.length < 6) {
                log.error("Formato incorrecto: " + linea);
            }

            // Crear CocheViejo
            CocheViejo cocheViejo = new CocheViejo();
            cocheViejo.setMatricula(valores[0]);
            cocheViejo.setMarca(valores[1]);
            cocheViejo.setModelo(valores[2]);
            cocheViejo.setColor(valores[3]);
            cocheViejo.setNKilimetros(Integer.valueOf(valores[4]));
            Optional<Cliente> optionalCliente = clienteRepository.findById(valores[5]);
            
            cocheViejoRepository.saveAndFlush(cocheViejo);
           
        }
    }
}

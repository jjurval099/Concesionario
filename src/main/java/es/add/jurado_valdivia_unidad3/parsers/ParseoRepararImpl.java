package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoReparar;
import es.add.jurado_valdivia_unidad3.models.Coche;
import es.add.jurado_valdivia_unidad3.models.CocheNuevo;
import es.add.jurado_valdivia_unidad3.models.Mecanico;
import es.add.jurado_valdivia_unidad3.models.Reparar;
import es.add.jurado_valdivia_unidad3.models.RepararId;
import es.add.jurado_valdivia_unidad3.repository.CocheNuevoRepository;
import es.add.jurado_valdivia_unidad3.repository.MecanicoRepository;
import es.add.jurado_valdivia_unidad3.repository.RepararRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;

@Service
public class ParseoRepararImpl implements IParseoReparar {

    @Autowired
    private RepararRepository repararRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Autowired
    private CocheNuevoRepository cocheRepository;

    @Override
    public void parseoReparar(Scanner scanner) throws ConcesionarioError {

        scanner.nextLine(); // Salta la cabecera

        while (scanner.hasNext()) {
            String linea = scanner.nextLine();
            String[] valores = linea.split(",");

            // Crear el RepararId
            RepararId repararId = new RepararId();
            repararId.setFechaReparacion(valores[0] );
            repararId.setDni(valores[1] );
            repararId.setMatricula(valores[2] );

            // Buscar el mecánico por DNI
            Optional<Mecanico> optionalMecanico = mecanicoRepository.findById(repararId.getDni());            

            // Buscar el coche por matrícula
            Optional<CocheNuevo> optionalCoche = cocheRepository.findById(repararId.getMatricula());
            

            // Crear Reparar
            Reparar reparar = new Reparar();
            reparar.setRepararId(repararId);
            reparar.setMecanico(optionalMecanico.get());
            reparar.setCoche(optionalCoche.get());
            reparar.setSalario(Integer.valueOf(valores[3] ));

            // Guardar en el repositorio
            repararRepository.saveAndFlush(reparar);
        }
    }
}

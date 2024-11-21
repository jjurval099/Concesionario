package es.add.jurado_valdivia_unidad3.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoMecanico;
import es.add.jurado_valdivia_unidad3.models.Mecanico;
import es.add.jurado_valdivia_unidad3.repository.MecanicoRepository;
import es.add.jurado_valdivia_unidad3.utils.ConcesionarioError;

@Service
public class ParseoMecanicoImpl implements IParseoMecanico {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Override
    public void parseoMecanico(Scanner scanner) throws ConcesionarioError {

        scanner.nextLine(); // Salta la cabecera

        while (scanner.hasNext()) 
        {
            String linea = scanner.nextLine();
            String[] valores = linea.split(",");


            // Crear Mecanico
            Mecanico mecanico = new Mecanico();
            mecanico.setDni(valores[0]);
            mecanico.setNombre(valores[1]);
            mecanico.setFechaContratacion(valores[2]);
            mecanico.setSalario(Integer.valueOf(valores[3]));

            // Guardar mecánico en la base de datos
            mecanicoRepository.saveAndFlush(mecanico);
        }
    }
}

package es.add.jurado_valdivia_unidad3.parsers;

import org.springframework.stereotype.Service;

import es.add.jurado_valdivia_unidad3.interfaces.IParseoCoche;
import es.add.jurado_valdivia_unidad3.models.Coche;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParseoCocheImpl implements IParseoCoche 
{
    @Override
    public Coche parseoCoche(String[] valores)
    {
        // Crear el objeto CocheNuevo
        Coche coche = new Coche();
        
        coche.setMatricula(valores[0]);
        coche.setMarca(valores[1]);
        coche.setModelo(valores[2]);
        coche.setColor(valores[3]);
        
        log.info("Nuevo coche creado {}", coche) ;
       
        return coche ;
    }
}

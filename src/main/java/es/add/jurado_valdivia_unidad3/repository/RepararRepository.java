package es.add.jurado_valdivia_unidad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.add.jurado_valdivia_unidad3.models.Reparar;
import es.add.jurado_valdivia_unidad3.models.RepararId;

public interface RepararRepository  extends JpaRepository<Reparar, RepararId>
{

}

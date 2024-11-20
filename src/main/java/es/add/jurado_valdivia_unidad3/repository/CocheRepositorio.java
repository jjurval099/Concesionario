package es.add.jurado_valdivia_unidad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.add.jurado_valdivia_unidad3.models.Coche;

public interface CocheRepositorio extends JpaRepository<Coche, String>
{

}

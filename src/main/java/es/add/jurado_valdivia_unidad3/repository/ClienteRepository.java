package es.add.jurado_valdivia_unidad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.add.jurado_valdivia_unidad3.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>
{

}

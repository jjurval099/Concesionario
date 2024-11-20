package es.add.jurado_valdivia_unidad3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mecanico 
{
	@Id
	private String dni;
	
	@Column(length = 15)
	private String nombre;
	
	@Column(length = 15)
	private String fechaContratacion;
	
	@Column(length = 15)
	private Integer salario;

}

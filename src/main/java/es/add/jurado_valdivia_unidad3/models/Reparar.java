package es.add.jurado_valdivia_unidad3.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reparar 
{
	@EmbeddedId 
	private RepararId repararId;
	
	@ManyToOne
	@JoinColumn(name="dni")
	@MapsId("dni")
	private Mecanico mecanico; 
	
	@ManyToOne
	@JoinColumn(name="matricula")
	@MapsId("matricula")
	private Coche coche; 
	
	@Column(length = 15)
	private Integer salario;


}

package es.add.jurado_valdivia_unidad3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Coche 
{
	@Id
	private String matricula;
	
	@Column(length = 15)
	private String marca;
	
	@Column(length = 15)
	private String modelo;
	
	@Column(length = 15)
	private String color;
	
	@ManyToOne
	private Cliente idCliente;
}

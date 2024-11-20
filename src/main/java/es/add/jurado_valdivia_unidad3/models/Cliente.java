package es.add.jurado_valdivia_unidad3.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente 
{	
	@Id
	private String nif;
	
	@Column(length = 15)
	private String nombre;
	
	@Column(length = 15)
	private String apellidos;
	
	@Column(length = 15)
	private String direccion;
	
	@Column(length = 15)
	private String telefono;
	
	@OneToOne
	private Descuento descuento;
	
	@OneToMany(mappedBy = "idCliente")
	private List<Coche> coches;

}

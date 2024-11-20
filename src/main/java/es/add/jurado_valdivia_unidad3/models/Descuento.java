package es.add.jurado_valdivia_unidad3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Descuento 
{
	@Id
	private String aro;
	
	private Integer importe;
	
	@OneToOne(mappedBy = "descuento")
	private Cliente cliente;
}

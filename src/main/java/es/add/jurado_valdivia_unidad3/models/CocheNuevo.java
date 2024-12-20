package es.add.jurado_valdivia_unidad3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CocheNuevo extends Coche
{
	@Column(length = 15)
	private Integer nUnidades;
	
	public CocheNuevo(Coche coche)
	{
		super(coche) ;
	}
}

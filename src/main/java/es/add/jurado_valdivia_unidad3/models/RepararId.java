package es.add.jurado_valdivia_unidad3.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RepararId  implements Serializable
{
	private static final long serialVersionUID = -8198549612707632593L;
	
	private String fechaReparacion;
	
	private String dni;
	
	private String matricula;

}

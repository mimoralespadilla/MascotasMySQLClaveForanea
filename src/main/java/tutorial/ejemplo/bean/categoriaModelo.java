package tutorial.ejemplo.bean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode

@Entity
public class categoriaModelo {
	@Id
	private String especie;
	
	private String mezcla;
	
	@ManyToOne
	@JoinColumn
	private Set<MascotasModelo> mascotas;
}

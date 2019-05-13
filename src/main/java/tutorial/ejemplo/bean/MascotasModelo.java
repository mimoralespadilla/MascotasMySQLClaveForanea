package tutorial.ejemplo.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data


@Entity
@Table(name = "mascotas")
public class MascotasModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToMany
	private String especie;

	private String name;

	private int edad;
	
	private String venta;

}

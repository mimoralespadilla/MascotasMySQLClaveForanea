package tutorial.ejemplo.repositorio;




import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tutorial.ejemplo.bean.MascotasModelo;

@Repository
public interface MascotasRepositorio extends CrudRepository<MascotasModelo, Integer> {
	Optional<MascotasModelo> findByname(String name);
	Iterable<MascotasModelo> findByEspecie(String especie);
	Iterable<MascotasModelo> findByMezcla(String mezcla);
	Iterable<MascotasModelo> findByEspecieAndMezcla(String especie,String mezcla);
}

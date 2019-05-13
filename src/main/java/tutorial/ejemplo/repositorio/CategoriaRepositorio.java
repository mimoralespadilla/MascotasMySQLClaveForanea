package tutorial.ejemplo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import tutorial.ejemplo.bean.categoriaModelo;

public interface CategoriaRepositorio extends JpaRepository<categoriaModelo, String>{

}

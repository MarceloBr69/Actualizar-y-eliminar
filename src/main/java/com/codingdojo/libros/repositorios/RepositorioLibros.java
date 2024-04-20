package com.codingdojo.libros.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.libros.modelos.LibrosModelo;
@Repository
public interface RepositorioLibros extends CrudRepository<LibrosModelo, Long>{
	//Este método recupera todos los libros de la base de datos
    List<LibrosModelo> findAll();
    //Este método encuentra un libro por su descripción
    List<LibrosModelo> findByDescripcionContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTituloContaining(String search);
    //Este método borra un libro que empieza con un título específico
	void deleteById(Long id); 

    
    
}

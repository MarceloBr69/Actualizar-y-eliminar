package com.codingdojo.libros.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.libros.modelos.LibrosModelo;
import com.codingdojo.libros.repositorios.RepositorioLibros;



@Service
public class LibrosServicios {
	@Autowired
	private RepositorioLibros repositorioLibros;

	//public LibrosServicios(RepositorioLibros repositorioLibros) {
		//this.repositorioLibros = repositorioLibros;
	//} 
	public List<LibrosModelo> obtenerTodos(){
		return repositorioLibros.findAll(); 
	}
	public LibrosModelo crearLibro(LibrosModelo lib) {
		return repositorioLibros.save(lib); 
	}
	public void eliminarLibro(Long id) {
		repositorioLibros.deleteById(id); 
	}
	public LibrosModelo obtenerPorId(Long id) {
		Optional<LibrosModelo> librosEncontrados = repositorioLibros.findById(id);
		return librosEncontrados.get(); 
	}
	public LibrosModelo modificarLibro(LibrosModelo librosModelo) {
		return repositorioLibros.save(librosModelo); 
	}
}

package com.codingdojo.libros.controlador;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.libros.modelos.LibrosModelo;
import com.codingdojo.libros.servicios.LibrosServicios;

import jakarta.validation.Valid;



@Controller
public class LibrosApi{
	@Autowired
	private LibrosServicios librosServicios;

	//public LibrosApi(LibrosServicios librosServicios) {
		//this.librosServicios = librosServicios;
	//} 
	@GetMapping("/")
	public String home(Model model, @ModelAttribute("LibrosModelo") LibrosModelo libro) {
		List<LibrosModelo> libros = this.librosServicios.obtenerTodos(); 
		model.addAttribute("libros", libros); 
		return "Home.jsp";
	}
	@PostMapping("/crearLibro")
    public String create(@Valid @ModelAttribute("LibrosModelo") LibrosModelo libro,
    					BindingResult result) {
		if(result.hasErrors()) {
			return "Home.jsp"; 
		}
		else {
			librosServicios.crearLibro(libro);
	        return "redirect:/"; 
		}
        
    }
	@PostMapping("/borrar/{id}")
	public String eliminarLibros(@RequestParam("id") Long id, 
								@ModelAttribute("LibrosModelo") 
								LibrosModelo libro) {
		librosServicios.eliminarLibro(id); 
		return "redirect:/"; 
	}
	
	@GetMapping("/libro/editar/{id}")
	public String modificarLibro(@ModelAttribute("LibrosModelo") LibrosModelo libro,
								@PathVariable("id") Long id,
								Model model) {
		LibrosModelo libroid = this.librosServicios.obtenerPorId(id); 
		model.addAttribute("libroid", libroid); 
		return "modificar.jsp";
	}
	@PostMapping("/editar")
	public String editarLibro(@Valid @ModelAttribute("librosmodelo") LibrosModelo librosmodelo,
								BindingResult result) {
		if(result.hasErrors()) {
			return "modificar.jsp"; 
		}
		else {
			this.librosServicios.modificarLibro(librosmodelo); 
			this.librosServicios.eliminarLibro(librosmodelo.getId()-1); 
			return "redirect:/"; 
		}
	}
	
	
	
	//Mostrar informacion de libro
	@PostMapping("/libro/{id}")
	public String infoLibro(@PathVariable("id") Long id, Model model) {
	    LibrosModelo libroid = this.librosServicios.obtenerPorId(id); 
	    model.addAttribute("libroid", libroid); 
	    return "info.jsp"; 
	}
	
	
	//Eliminar informacion
	@DeleteMapping("/libro/borrar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		librosServicios.eliminarLibro(id);	
		return "redirect:/"; 
	}
	
	

	
	
}

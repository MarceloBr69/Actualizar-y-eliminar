package com.codingdojo.libros.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class LibrosModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private String titulo; 
	
	private String descripcion;
	
	private String lenguaje;
	
	private int numerosDePaginas; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaCreacion;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaActualizacion;


	
	//Construcotres
	public LibrosModelo() {}

	public LibrosModelo(String titulo, String descripcion, String lenguaje, int numerosDePaginas) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.lenguaje = lenguaje;
		this.numerosDePaginas = numerosDePaginas;
	}
	//Creacion automatica de fechas al crear y modificar
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date(); 
	}
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion =  new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public int getNumerosDePaginas() {
		return numerosDePaginas;
	}

	public void setNumerosDePaginas(int numerosDePaginas) {
		this.numerosDePaginas = numerosDePaginas;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
	
	
}

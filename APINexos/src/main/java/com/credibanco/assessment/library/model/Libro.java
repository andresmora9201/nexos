package com.credibanco.assessment.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro implements Serializable {
	
	@Id
	@Column(name="id_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLibro;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="año")
	private String año;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="numero_paginas")
	private Long numeroPaginas;
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="id_editorial")
	private Editorial editorial;
	
	@OneToOne()
	@JoinColumn(name="id_autor")
	private Autor autor;	
	
			
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Libro(String titulo, String año, String genero, Long numeroPaginas, Editorial editorial, Autor autor) {
		super();
		this.titulo = titulo;
		this.año = año;
		this.genero = genero;
		this.numeroPaginas = numeroPaginas;		
		this.editorial = editorial;
		this.autor = autor;
	}
	public Long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Long numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
		
	

}

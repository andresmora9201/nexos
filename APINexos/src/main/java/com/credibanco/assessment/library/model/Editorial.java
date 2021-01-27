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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="editorial")
public class Editorial implements Serializable {
	
	@Id
	@Column(name="id_editorial")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEditorial;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion_correspondecia")
	private String direccionCorrespondencia;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="maximo_libros")
	private Long maximoLibros;	
	
	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonCreator
	public Editorial(@JsonProperty("nombre") String nombre, @JsonProperty("direccionCorrespondencia") String direccionCorrespondencia, @JsonProperty("telefono") String telefono, @JsonProperty("correo") String correo, @JsonProperty("maximoLibros") Long maximoLibros) {
		super();		
		this.nombre = nombre;
		this.direccionCorrespondencia = direccionCorrespondencia;
		this.telefono = telefono;
		this.correo = correo;
		this.maximoLibros = maximoLibros;
		
	}
	public Long getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(Long idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccionCorrespondencia() {
		return direccionCorrespondencia;
	}
	public void setDireccionCorrespondencia(String direccionCorrespondencia) {
		this.direccionCorrespondencia = direccionCorrespondencia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getMaximoLibros() {
		return maximoLibros;
	}
	public void setMaximoLibros(Long maximoLibros) {
		this.maximoLibros = maximoLibros;
	}
	
	
	
	

}

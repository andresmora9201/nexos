package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="autor")
public class Autor implements Serializable {
	
	@Id
	@Column(name="id_autor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAutor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name="ciudad_procedencia")
	private String ciudadProcedencia;
	
	@Column(name="correo")
	private String correo;	
	
			
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonCreator
	public Autor(@JsonProperty("nombre") String nombre, @JsonProperty("fechaNacimiento") Date fechaNacimiento, @JsonProperty("ciudadProcedencia") String ciudadProcedencia, @JsonProperty("correo") String correo) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadProcedencia = ciudadProcedencia;
		this.correo = correo;
	}
	
	public Long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCiudadProcedencia() {
		return ciudadProcedencia;
	}
	public void setCiudadProcedencia(String ciudadProcedencia) {
		this.ciudadProcedencia = ciudadProcedencia;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	

}

package com.vale.chat.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document( collection = "mensajes" )
public class Mensaje implements Serializable{

	@Id
	private String id;
	
	private String texto;
	private Long fecha;
	private String username;
	private String color;
	private String tipo;

	public String getTexto() {
		return texto;
	}

	public Long getFecha() {
		return fecha;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	private static final long serialVersionUID = 4841854728696606466L;

}

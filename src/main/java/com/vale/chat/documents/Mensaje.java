package com.vale.chat.documents;

import java.io.Serializable;

public class Mensaje implements Serializable{

	private String texto;
	private Long fecha;

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

	private static final long serialVersionUID = 4841854728696606466L;

}

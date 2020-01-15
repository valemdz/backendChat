package com.vale.chat.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notificacion {
	
	@Id
	private String id;	
	private String username;
	private LocalDateTime createdAt;
	private String mensaje;
	
	public String getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "Notificacion [id=" + id + ", username=" + username + ", createdAt=" + createdAt + ", mensaje=" + mensaje
				+ "]";
	}
	
    
}

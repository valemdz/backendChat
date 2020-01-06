package com.vale.chat.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.vale.chat.documents.Mensaje;

@Controller
public class ChatControler {
	
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje") // aca hay que suscribirse
	public Mensaje recibeMensaje( Mensaje mensaje ){
		mensaje.setFecha( new java.util.Date().getTime() );
		mensaje.setTexto( "Recibido por el Broker " + mensaje.getTexto() );
		return mensaje; 
	}
	

}

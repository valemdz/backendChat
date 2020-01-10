package com.vale.chat.controllers;


import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.vale.chat.documents.Mensaje;
import com.vale.chat.services.ChatService;

@Controller
public class ChatControler {
	
	public static String NUEVO_USUARIO = "NUEVO_USUARIO";
	public static String MENSAJE = "MENSAJE";
	private String[] colores = {"red", "green", "blue", "magenta", "purple", "orange"};
	
	@Autowired 	ChatService chatService;
	@Autowired SimpMessagingTemplate webSocket;	
	
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje") // aca hay que suscribirse
	public Mensaje recibeMensaje( Mensaje mensaje ){
		mensaje.setFecha( new java.util.Date().getTime() );
		
		if( mensaje.getTipo().equalsIgnoreCase(NUEVO_USUARIO) ){
			Random random = new Random();
			int randomIndex = random.nextInt(colores.length);
			mensaje.setTexto( "Se conecto el usuario ");
			mensaje.setColor(colores[ randomIndex  ]);
		}
		
		chatService.saveMensaje( mensaje );
		
		return mensaje; 
	}
	
	
	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo")
	public String escribiendoMensaje( String usuario ) {
		return usuario.concat(" escribiendo....");
	}
	
	
	@MessageMapping("/historial")	
	public void  getHistorial( String usuarioID ) {
		// Es lo mismo que el sendTo
		webSocket.convertAndSend("/chat/historial/"+ usuarioID, chatService.getHistorial());		
	}

}

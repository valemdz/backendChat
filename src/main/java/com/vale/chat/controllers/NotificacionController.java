package com.vale.chat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vale.chat.cliente.ClienteWebSocket;
import com.vale.chat.components.WebClientChat;
import com.vale.chat.documents.Notificacion;
import com.vale.chat.services.NotificacionService;

@RestController
public class NotificacionController {
	
	@Autowired
	NotificacionService notificacionService;
	
	@Autowired
	ClienteWebSocket clienteWebSocket;
	
	
	@PostMapping("/notificaciones")
	@ResponseStatus( HttpStatus.CREATED )
	Notificacion saveNotificaciones( @RequestBody Notificacion noti  ) {
		//clienteWebSocket.enviarMensaje("VTORRES");
		Notificacion notiSaved = notificacionService.save(noti); 
		clienteWebSocket.avisarNotificaciones( noti.getUsername() );
		return notiSaved;
	}
	
	@GetMapping("/notificaciones")
	@ResponseStatus( HttpStatus.OK )
	List<Notificacion> findAllNotificaciones() {		
		return notificacionService.findAllNotificaciones();
	}

}

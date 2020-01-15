package com.vale.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vale.chat.documents.Notificacion;
import com.vale.chat.services.NotificacionService;

@RestController
public class NotificacionController {
	
	@Autowired
	NotificacionService notificacionService;
	
	@PostMapping("/notificaciones")
	@ResponseStatus( HttpStatus.CREATED )
	Notificacion saveNotificaciones( @RequestBody Notificacion noti  ) {
		return notificacionService.save(noti);
	}

}

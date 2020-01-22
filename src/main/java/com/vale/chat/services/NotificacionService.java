package com.vale.chat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vale.chat.documents.Notificacion;
import com.vale.chat.repositories.NotificacionRepository;

@Service
@Transactional( readOnly = true )
public class NotificacionService {
	
	@Autowired
	NotificacionRepository notiRepository; 
	
	
	@Transactional( readOnly = false )
	public Notificacion save( Notificacion noti ) {
		return notiRepository.save( noti ) ;		
	}
	
	@Transactional( readOnly = true )
	public List<Notificacion> findByUsername( String username ) {
		return notiRepository.findByUsername( username );
	}
	
	@Transactional( readOnly = true )
	public List<Notificacion> findAllNotificaciones() {
		return notiRepository.findAll();
	}
	
}

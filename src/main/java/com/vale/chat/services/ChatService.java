package com.vale.chat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vale.chat.documents.Mensaje;
import com.vale.chat.repositories.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	
	
	public List<Mensaje> getHistorial(){
		return chatRepository.findFirst10ByOrderByFechaDesc();
	}
	
	public void saveMensaje( Mensaje mensaje ) {
	  chatRepository.save( mensaje );		
	}

}

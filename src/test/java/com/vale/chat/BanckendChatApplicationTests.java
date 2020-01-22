package com.vale.chat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vale.chat.documents.Notificacion;
import com.vale.chat.repositories.NotificacionRepository;

@SpringBootTest
class BanckendChatApplicationTests {
	
	/*@Autowired
	NotificacionRepository notificacionRepository;

	@Test
	void contextLoads() {
		List< Notificacion > notis = notificacionRepository.findByUsername("VTORRES");
		notis.forEach( System.out::println );	
		
	}*/

}

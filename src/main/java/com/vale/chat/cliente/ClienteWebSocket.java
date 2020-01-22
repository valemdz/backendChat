package com.vale.chat.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import com.vale.chat.documents.Mensaje;



@Component
public class ClienteWebSocket {
	
	private static String URL = "ws://localhost:8080/chat-websocket";
	
	WebSocketStompClient stompClient;
	
	
	private Map<String, StompSession> map_users = new ConcurrentHashMap<>();
	

	public void avisarNotificaciones( String userId ) {	
		
		try {
			
			StompSession session = map_users.get( userId ); 
			
			if( session == null ) {
				StompSessionHandler sessionHandler = new NotificacionesStompSessionHandler(userId);
				session = stompClient.connect(URL, sessionHandler).get();
				map_users.put(userId, session);
			}
					
			session.send("/app/notificaciones", userId );			
				
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	public void enviarMensaje( String userId ){		
		
		StompSessionHandler sessionHandler = new CustomStompSessionHandler(userId);
		StompSession session;
		try {
			session = stompClient.connect(URL, sessionHandler).get();
			
			Mensaje mensaje = getSampleMessage();
			mensaje.setUsername(userId);			
			session.send("/app/mensaje", mensaje );	
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public ClienteWebSocket() {		
		WebSocketClient simpleWebSocketClient = new StandardWebSocketClient();
		List<Transport> transports = new ArrayList<>(1);
		transports.add(new WebSocketTransport(simpleWebSocketClient));
		SockJsClient sockJsClient = new SockJsClient(transports);
		stompClient = new WebSocketStompClient(sockJsClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());		
	}
		
	 private Mensaje getSampleMessage() {
	    	Mensaje msg = new Mensaje();
	    	msg.setTexto("Hola soy vale tORRES desde el cliente websocket!!!!");
	    	msg.setColor("blue");
	    	msg.setTipo("MENSAJE");
	        
	        return msg;
	}
	
}

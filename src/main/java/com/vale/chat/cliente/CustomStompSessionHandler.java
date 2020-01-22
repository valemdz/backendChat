package com.vale.chat.cliente;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.vale.chat.documents.Mensaje;


public class CustomStompSessionHandler extends StompSessionHandlerAdapter{
	
	private String userId;

	public CustomStompSessionHandler(String userId) {
		this.userId = userId;
	}

	private void showHeaders(StompHeaders headers) {
		for (Map.Entry<String, List<String>> e : headers.entrySet()) {
			System.err.print("  " + e.getKey() + ": ");
			boolean first = true;
			for (String v : e.getValue()) {
				if (!first)
					System.err.print(", ");
				System.err.print(v);
				first = false;
			}
			System.err.println();
		}
	}	

	private void subscribeTopic(String topic, StompSession session) {
		session.subscribe(topic, new StompFrameHandler() {

			@Override
			public Type getPayloadType(StompHeaders headers) {
				return Mensaje.class;
			}

			@Override
			public void handleFrame( StompHeaders headers, Object payload ) {
				Mensaje mensaje = (Mensaje)payload;
				System.err.println( "Mge Chat " +  mensaje.toString() );
			}
		});
	}

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		System.err.println("Connected! Headers:");
		showHeaders(connectedHeaders);
		subscribeTopic("/chat/mensaje", session);

	}

}

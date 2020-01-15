package com.vale.chat.components;

import java.net.URI;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class WebClientChat {

	WebClient clientChat;
	
	public WebClient getInstanceClienteChat(){
		
		if( clientChat == null ) {
			clientChat = WebClient
						  .builder()
						    .baseUrl("http://localhost:8080")
						    .defaultCookie("cookieKey", "cookieValue")
						    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
						    .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
						  .build();			
		}
		
		return clientChat;
	}
	
	public void publishNotificacion( String username) {
		
		/*WebClient.RequestHeadersSpec requestSpec1 = clientChat
				  .post()
				  .uri("/resource")
				  .body(BodyInserters.fromPublisher(Mono.just( username )), String.class);*/
		
	}		
	
	
}

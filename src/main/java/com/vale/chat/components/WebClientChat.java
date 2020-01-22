package com.vale.chat.components;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class WebClientChat {

	/*WebClient webClient;
	
	public WebClient getInstanceClienteChat(){
		
		if( webClient == null ) {
			webClient = WebClient
						  .builder()
						  .baseUrl("http://localhost:8080")						    
						  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)						    
						  .build();			
		}
		
		return webClient;
	}*/
	
	public void publishNotificacion( String username) {
		
	
		WebClient webClient = WebClient
				  .builder()
				  .baseUrl("http://localhost:8080")						    
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)						    
				  .build();			
	
		
		String urlFinal = "/app/notificaciones/VTORRES";			
		
		
		BodyInserters.fromPublisher(Flux.just("VTORRES"),String.class);
		Mono<String> respuesta1 = webClient.post().uri(urlFinal).body(BodyInserters.fromObject("VTORRES")).exchange()
			.flatMap( x -> 
			{ 
				if ( ! x.statusCode().is2xxSuccessful())
					return 	Mono.just( urlFinal+" Called. Error 4xx: "+x.statusCode()+"\n");
				return x.bodyToMono(String.class);
			});	    	
				
		
	}		
	
	
}

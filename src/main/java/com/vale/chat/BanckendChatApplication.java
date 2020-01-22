package com.vale.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BanckendChatApplication {
	
	
	//private static String URL = "ws://localhost:8080/chat-websocket";
	//Logger logger = LoggerFactory.getLogger( BanckendChatApplication.class );
	

	public static void main(String[] args) {
		SpringApplication.run(BanckendChatApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		logger.info("supuestamente");
		
		WebSocketClient client = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        stompClient.connect(URL, sessionHandler);

        new Scanner(System.in).nextLine(); // Don't close immediately.
		
	}*/

}

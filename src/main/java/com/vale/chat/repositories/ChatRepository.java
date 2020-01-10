package com.vale.chat.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vale.chat.documents.Mensaje;

public interface ChatRepository extends MongoRepository<Mensaje, String >{
	
	
	public List<Mensaje> findFirst10ByOrderByFechaDesc();

}

package com.vale.chat.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vale.chat.documents.Notificacion;


public interface NotificacionRepository extends MongoRepository<Notificacion, String > {

	List<Notificacion> findByUsername( String username );
}

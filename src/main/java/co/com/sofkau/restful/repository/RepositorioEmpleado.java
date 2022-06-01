package co.com.sofkau.restful.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.sofkau.restful.model.Empleado;

@Repository
public interface RepositorioEmpleado extends MongoRepository<Empleado, String> {

}

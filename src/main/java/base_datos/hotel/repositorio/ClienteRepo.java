package base_datos.hotel.repositorio;

import base_datos.hotel.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();
}

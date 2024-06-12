package base_datos.hotel.repositorio;

import base_datos.hotel.entidad.Colaborador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorRepo extends CrudRepository <Colaborador, Long> {
    Optional<Colaborador> findByNombreUsuario(String nombreUsuario);
    List<Colaborador> findAll();
}

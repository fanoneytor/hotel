package base_datos.hotel.repositorio;

import base_datos.hotel.entidad.Habitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepo extends CrudRepository <Habitacion, Long> {
    List<Habitacion> findAll();

    @Query(value="select * from habitaciones where estado = 'Disponible'", nativeQuery=true)
    List<Habitacion> habitacionesDisponibles();
}

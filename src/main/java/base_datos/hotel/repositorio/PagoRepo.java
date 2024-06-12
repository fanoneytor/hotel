package base_datos.hotel.repositorio;

import base_datos.hotel.entidad.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepo extends CrudRepository <Pago, Long> {
}

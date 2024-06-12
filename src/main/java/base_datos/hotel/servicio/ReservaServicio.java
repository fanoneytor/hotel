package base_datos.hotel.servicio;

import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.entidad.Reserva;
import base_datos.hotel.repositorio.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {
    @Autowired
    private ReservaRepo reservaRepo;


    public Reserva guardarReserva(Reserva nuevaReserva) {
        return reservaRepo.save(nuevaReserva);
    }

    public List<Reserva> todasLasReservas(){
        return (List<Reserva>) reservaRepo.findAll();
    }

    public void eliminarReserva(Long id) {
        reservaRepo.deleteById(id);
    }
}

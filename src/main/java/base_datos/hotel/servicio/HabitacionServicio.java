package base_datos.hotel.servicio;

import base_datos.hotel.entidad.Habitacion;
import base_datos.hotel.repositorio.HabitacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServicio {
    @Autowired
    private HabitacionRepo habitacionRepo;

    public List<Habitacion> habitaciones(){
        return habitacionRepo.findAll();
    }

    public List<Habitacion> habitacionesDisponibles(){
        return habitacionRepo.habitacionesDisponibles();
    }

    public Habitacion guardarHabitacion(Habitacion habitacion) {
        return habitacionRepo.save(habitacion);
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepo.deleteById(id);
    }
}

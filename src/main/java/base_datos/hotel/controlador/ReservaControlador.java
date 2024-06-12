package base_datos.hotel.controlador;

import base_datos.hotel.entidad.Cliente;
import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.entidad.Reserva;
import base_datos.hotel.repositorio.HabitacionRepo;
import base_datos.hotel.servicio.ClienteServicio;
import base_datos.hotel.servicio.HabitacionServicio;
import base_datos.hotel.servicio.ReservaServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaControlador {
    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private HabitacionServicio habitacionServicio;

    @GetMapping("/nuevaReserva")
    public String newProject(@ModelAttribute("reserva") Reserva reserva,
                             HttpSession session,
                             Model model) {
        //REVISAMOS LA SESION
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }

        model.addAttribute("clientes", clienteServicio.clientes());
        model.addAttribute("habitaciones", habitacionServicio.habitacionesDisponibles());
        return "nuevaReserva.jsp";
    }

    @PostMapping("/crear")
    public String createProject(@Validated @ModelAttribute("reserva") Reserva reserva,
                                BindingResult result,
                                HttpSession session,
                                Model model) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            model.addAttribute("clientes", clienteServicio.clientes());
            model.addAttribute("habitaciones", habitacionServicio.habitacionesDisponibles());
            return "nuevaReserva.jsp";
        } else {
            Reserva nuevaReserva = reservaServicio.guardarReserva(reserva);
            return "redirect:/inicio";
        }
    }

    @GetMapping("/eliminar/{reservaId}")
    public String eliminarHabitacion(@PathVariable("reservaId") Long reservaId,
                                     HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if(currentUser == null) {
            return "redirect:/";
        }

        reservaServicio.eliminarReserva(reservaId);
        return"redirect:/reservas/";
    }
}

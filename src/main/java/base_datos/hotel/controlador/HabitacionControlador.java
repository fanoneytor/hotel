package base_datos.hotel.controlador;

import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.entidad.Habitacion;
import base_datos.hotel.servicio.HabitacionServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionControlador {
    @Autowired
    private HabitacionServicio habitacionServicio;

    @GetMapping("/")
    public String habitacionInicio(HttpSession session,
                                Model model) {

        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }

        model.addAttribute("habitaciones", habitacionServicio.habitaciones());
        return "habitacionesInicio.jsp";
    }

    @GetMapping("/nuevaHabitacion")
    public String nuevaHabitacion(@ModelAttribute("habitacion") Habitacion habitacion,
                               HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }
        return "crearHabitacion.jsp";
    }

    @PostMapping("/crear")
    public String crearHabitacion(@Validated @ModelAttribute("habitacion") Habitacion habitacion,
                              BindingResult result,
                              HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "crearHabitacion.jsp";
        } else {
            Habitacion nuevaHabitacion = habitacionServicio.guardarHabitacion(habitacion);
            return "redirect:/inicio";
        }
    }

    @GetMapping("/eliminar/{habitacionId}")
    public String eliminarHabitacion(@PathVariable("habitacionId") Long habitacionId,
                           HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if(currentUser == null) {
            return "redirect:/";
        }

        habitacionServicio.eliminarHabitacion(habitacionId);
        return"redirect:/habitaciones/";
    }
}

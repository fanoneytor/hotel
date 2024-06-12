package base_datos.hotel.controlador;

import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.entidad.LoginColaborador;
import base_datos.hotel.entidad.Reserva;
import base_datos.hotel.servicio.ColaboradorServicio;
import base_datos.hotel.servicio.ReservaServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ColaboradorControlador {
    @Autowired
    private ColaboradorServicio colaboradorServicio;

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/")
    public String index(@ModelAttribute("nuevoLogin") LoginColaborador nuevoLogin) {
        return "index.jsp";
    }

    @GetMapping("/inicio")
    public String dashboard(HttpSession session,
                            Model model) {

        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }
        List<Reserva> reservas = reservaServicio.todasLasReservas();
        model.addAttribute("reservas", reservas);
        model.addAttribute("reservas", reservas);
        return "inicio.jsp";
    }

    @GetMapping("/registrar")
    public String registrar(@ModelAttribute("nuevoUsuario") Colaborador nuevoUsuario) {
        return "registro.jsp";
    }

    @PostMapping("/registrar")
    public String register(@Validated @ModelAttribute("nuevoUsuario") Colaborador nuevoUsuario,
                           BindingResult result,
                           Model model,
                           HttpSession session) {
        colaboradorServicio.register(nuevoUsuario, result);

        if(result.hasErrors()) {
            model.addAttribute("nuevoLogin", new LoginColaborador()); //Enviamos login User vacio
            return "registro.jsp";
        }else {
            //session.setAttribute("userSession", nuevoUsuario);
            return "redirect:/colaboradorInicio";
        }

    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("nuevoLogin") LoginColaborador nuevoLogin,
                        BindingResult result,
                        Model model,
                        HttpSession session) {

        Colaborador colaborador = colaboradorServicio.login(nuevoLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("nuevoUsuario", new Colaborador());
            return "index.jsp";
        }

        session.setAttribute("userSession", colaborador);
        return "redirect:/inicio";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userSession");
        return "redirect:/";
    }

    @GetMapping("/colaboradorInicio")
    public String colaboradorInicio(HttpSession session,
                                Model model) {

        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }
        List<Colaborador> colaboradores = colaboradorServicio.colaboradores();
        model.addAttribute("colaboradores", colaboradores);
        return "colaboradoresInicio.jsp";
    }

    @GetMapping("/eliminar/{colaboradorId}")
    public String eliminarHabitacion(@PathVariable("colaboradorId") Long colaboradorId,
                                     HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if(currentUser == null) {
            return "redirect:/";
        }

        colaboradorServicio.eliminarColaborador(colaboradorId);
        return"redirect:/colaboradorInicio";
    }

}

package base_datos.hotel.controlador;

import base_datos.hotel.entidad.Cliente;
import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.servicio.ClienteServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/")
    public String clienteInicio(HttpSession session,
                                Model model) {

        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }
        List<Cliente> clientes = clienteServicio.clientes();
        model.addAttribute("clientes", clientes);
        return "clientesInicio.jsp";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(@ModelAttribute("cliente") Cliente cliente,
                               HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }
        return "crearCliente.jsp";
    }

    @PostMapping("/crear")
    public String crarCliente(@Validated @ModelAttribute("cliente") Cliente cliente,
                              BindingResult result,
                              HttpSession session) {
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if (currentUser == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "crearCliente.jsp";
        } else {
            Cliente nuevoCliente = clienteServicio.guardarCliente(cliente);
            return "redirect:/inicio";
        }
    }


    @GetMapping("/eliminar/{clienteId}")
    public String eliminar(@PathVariable("clienteId") Long clienteId,
                        HttpSession session) {
        //REVISAMOS LA SESION
        Colaborador currentUser = (Colaborador) session.getAttribute("userSession");

        if(currentUser == null) {
            return "redirect:/";
        }

        //Metodo en Servicio que nos elimine un proyecto
        clienteServicio.eliminarCliente(clienteId);
        return"redirect:/clientes/";
    }


}

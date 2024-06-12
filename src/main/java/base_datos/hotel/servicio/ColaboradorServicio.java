package base_datos.hotel.servicio;

import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.entidad.LoginColaborador;
import base_datos.hotel.repositorio.ColaboradorRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class ColaboradorServicio {

    @Autowired
    private ColaboradorRepo colaboradorRepo;

    public Colaborador register(Colaborador nuevoUsuario, BindingResult result) {

        //Revisar si el correo electronico ya existe
        String nuevoNombreUsuario = nuevoUsuario.getNombreUsuario();
        if(colaboradorRepo.findByNombreUsuario(nuevoNombreUsuario).isPresent()){
            result.rejectValue("nombreUsuario", "Unique", "El Nombre de Usuario ya fue ingresado previamente.");
        }

        if(result.hasErrors()) {
            return null;
        }else {
            //Encriptar la contraseña
            String contraEncriptada = BCrypt.hashpw(nuevoUsuario.getContra(), BCrypt.gensalt());
            nuevoUsuario.setContra(contraEncriptada);
            return colaboradorRepo.save(nuevoUsuario);
        }
    }

    public Colaborador login(LoginColaborador nuevoLogin, BindingResult result) {

        //Buscamos por correo electronico
        Optional<Colaborador> posibleUsuario = colaboradorRepo.findByNombreUsuario(nuevoLogin.getNombreUsuario());

        if(!posibleUsuario.isPresent()) {
            result.rejectValue("nombreUsuario", "Unique", "El Nombre de usuario no esta registrado");
            return null;
        }

        Colaborador userLogin = posibleUsuario.get(); //Usuario que me regresa mi BD
        if(!BCrypt.checkpw(nuevoLogin.getContra(), userLogin.getContra())) {
            result.rejectValue("contra", "Matches", "Contraseña Invalida!");
        }

        if(result.hasErrors()) {
            return null;
        }else {
            return userLogin;
        }
    }

    public List<Colaborador> colaboradores(){
        return colaboradorRepo.findAll();
    }

    public void eliminarColaborador(Long id) {
        colaboradorRepo.deleteById(id);
    }
}

package base_datos.hotel.servicio;

import base_datos.hotel.entidad.Cliente;
import base_datos.hotel.entidad.Colaborador;
import base_datos.hotel.entidad.Reserva;
import base_datos.hotel.repositorio.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepo repo;

    public Cliente guardarCliente(Cliente cliente) {
        return repo.save(cliente);
    }

    public List<Cliente> clientes(){
        return repo.findAll();
    }

    public void eliminarCliente(Long id) {
        repo.deleteById(id);
    }

}

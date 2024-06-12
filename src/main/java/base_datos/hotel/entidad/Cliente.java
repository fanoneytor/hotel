package base_datos.hotel.entidad;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_cliente;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Correo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_reserva")
    private Reserva reserva;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    public Cliente() {
    }

    public Long getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        Id_cliente = id_cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
}

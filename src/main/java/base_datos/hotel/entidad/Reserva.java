package base_datos.hotel.entidad;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table (name="Reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_reserva;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha_inicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha_fin;

    private String Estado;

    @OneToMany(mappedBy = "Numero_reserva", fetch = FetchType.LAZY)
    private List<Habitacion> Id_habitaciones;

    @OneToOne(mappedBy = "reserva")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_pago")
    private Pago pago;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    public Reserva() {
    }

    public Long getId_reserva() {
        return Id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        Id_reserva = id_reserva;
    }

    public Date getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        Fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        Fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public List<Habitacion> getId_habitaciones() {
        return Id_habitaciones;
    }

    public void setId_habitaciones(List<Habitacion> id_habitaciones) {
        Id_habitaciones = id_habitaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
}



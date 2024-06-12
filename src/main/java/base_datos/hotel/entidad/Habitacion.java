package base_datos.hotel.entidad;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table (name = "Habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_habitacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_reserva")
    private Reserva Numero_reserva;
    @Column(unique = true)
    private Integer Numero_habitacion;
    private String Estado;
    private String Tipo_habitacion;
    private Integer Precio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    public Habitacion() {
    }

    public Long getId_habitacion() {
        return Id_habitacion;
    }

    public void setId_habitacion(Long id_habitacion) {
        Id_habitacion = id_habitacion;
    }

    public Reserva getNumero_reserva() {
        return Numero_reserva;
    }

    public void setNumero_reserva(Reserva numero_reserva) {
        Numero_reserva = numero_reserva;
    }

    public Integer getNumero_habitacion() {
        return Numero_habitacion;
    }

    public void setNumero_habitacion(Integer numero_habitacion) {
        Numero_habitacion = numero_habitacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTipo_habitacion() {
        return Tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        Tipo_habitacion = tipo_habitacion;
    }

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer precio) {
        Precio = precio;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
}

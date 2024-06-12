package base_datos.hotel.entidad;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_pago;
    private Integer Monto;

    @OneToOne(mappedBy = "pago")
    private Reserva reserva;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    public Pago() {
    }

    public Long getId_pago() {
        return Id_pago;
    }

    public void setId_pago(Long id_pago) {
        Id_pago = id_pago;
    }

    public Integer getMonto() {
        return Monto;
    }

    public void setMonto(Integer monto) {
        Monto = monto;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
}

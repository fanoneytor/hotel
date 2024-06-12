package base_datos.hotel.entidad;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Colaboradores")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_colaborador;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contra;
    private String rol;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    public Colaborador() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Long getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(Long id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
}

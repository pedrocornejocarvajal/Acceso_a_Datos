import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "Personas")
public class PersonasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) //Para decir que es autoincrementada
    @Column(name = "idPersona")
    private int idPersona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "saldo")
    private double saldo;

    public PersonasEntity() {

    }

    public PersonasEntity(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public PersonasEntity(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

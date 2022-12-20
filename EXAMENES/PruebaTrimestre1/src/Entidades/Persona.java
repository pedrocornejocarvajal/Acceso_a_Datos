package Entidades;

public class Persona {

    private int idPersona;
    private String nombre;
    private double saldo;

    public Persona(int idPersona, String nombre, double saldo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Persona() {
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

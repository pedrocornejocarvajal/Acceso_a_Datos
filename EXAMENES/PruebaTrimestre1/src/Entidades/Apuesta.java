package Entidades;

public class Apuesta {

    private int idApuesta;
    private int numSorteo;
    private int idPersona;
    private int numero;

    public Apuesta(int idApuesta, int numSorteo, int idPersona, int numero) {
        this.idApuesta = idApuesta;
        this.numSorteo = numSorteo;
        this.idPersona = idPersona;
        this.numero = numero;
    }

    public Apuesta() {
    }

    public int getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(int idApuesta) {
        this.idApuesta = idApuesta;
    }

    public int getNumSorteo() {
        return numSorteo;
    }

    public void setNumSorteo(int numSorteo) {
        this.numSorteo = numSorteo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}

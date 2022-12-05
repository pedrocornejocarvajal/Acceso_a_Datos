package Entidades;

public class Sorteo {

    private int numSorteo;
    private double recaudacion;
    private  double bote;
    private int num1;
    private int num2;
    private int num3;


    public Sorteo(int numSorteo, double recaudacion, double bote, int num1, int num2, int num3) {
        this.numSorteo = numSorteo;
        this.recaudacion = recaudacion;
        this.bote = bote;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public Sorteo() {
    }

    public int getNumSorteo() {
        return numSorteo;
    }

    public void setNumSorteo(int numSorteo) {
        this.numSorteo = numSorteo;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }
}

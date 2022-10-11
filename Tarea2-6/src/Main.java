import java.io.*;

public class Main {
    static RandomAccessFile segundoFichero = null;
    static RandomAccessFile ficheroInicial = null;
    static RandomAccessFile ficherofinal = null;

    public static void main(String[] args) {

        creacionFicheros();

       // primerEjercicio();

        segundoEjercicioInversa();

        cerrarFicheros(ficheroInicial);
        cerrarFicheros(ficherofinal);
        cerrarFicheros(segundoFichero);


    }


    /**
     * Metodo para mostrar por pantalla el contenido del fichero
     */
    public static void mostrarFichero(RandomAccessFile ficheroLeido) {
        String n;
        try {
            ficheroLeido.seek(0); //nos situamos al principio
            for (int i = 0; i < ficheroLeido.length(); i++) {
                n = String.valueOf(ficheroLeido.read());  //se lee el dato dentro del archivo
                System.out.println(n);  //se muestra en pantalla
            }
        } catch (IOException e) {

        }
    }

    /**
     * Metodo para crear los ficheros necesarios para el ejercicio
     */
    public static void creacionFicheros() {
        try {
            //se abren los ficheros para lectura y escritura
            segundoFichero = new RandomAccessFile("src/fichero.txt", "rw");
            ficherofinal = new RandomAccessFile("src/ficheroFinal.txt", "rw");
            ficheroInicial = new RandomAccessFile("src/ficheroInicial.txt", "rw");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Metodo para cerrar los ficheros que se necesiten cerrar
     *
     * @param ficheroCerrado
     */
    public static void cerrarFicheros(RandomAccessFile ficheroCerrado) {

        try {
            if (ficheroCerrado != null) {
                ficheroCerrado.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que resuelve el priemr ejercicio, este lee el ficheroInicial y escribe 5 veces en el segundo fichero el dato leido en el primer fichero
     */
    public static void primerEjercicio() {

        char dato;
        try {
            dato = ficheroInicial.readLine().charAt(0); //leemos el caracter del fichero inicial
            for (int i = 0; i < 5; i++) {
                segundoFichero.seek(i); //nos posicionamos en la posicion i
                segundoFichero.write(dato); // escribe lo que queremos hasta en la posicion que le toca
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void segundoEjercicioInversa() {
        try {


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
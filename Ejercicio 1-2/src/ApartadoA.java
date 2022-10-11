import java.io.*;

public class ApartadoA {
    public static void main(String[] args) throws IOException {
        File ficheroLectura = new File("src\\palabras.txt");
        File ficheroEscritura = new File("src\\final.txt");
        FileReader lectura = new FileReader(ficheroLectura);
        FileWriter escritura = new FileWriter(ficheroEscritura);
        char[] letras = new char[5];
        while ((lectura.read(letras)) != -1) {
            escritura.write(letras);
            escritura.write("\n");
        }
        lectura.close();
        escritura.close();
}
}
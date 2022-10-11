import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ApartadoB {
    public static void main(String[] args) throws IOException {
        File fichero1 = new File("src\\final.txt");
        File fichero2 = new File("src\\ordenado.txt");
        FileInputStream input = new FileInputStream(fichero1);
        FileOutputStream output = new FileOutputStream(fichero2);
        BufferedReader lector = new BufferedReader(new InputStreamReader(input));
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(output));
        String aLine;
        ArrayList<String> lista = new ArrayList<> ();

        int i = 0;
        while ((aLine = lector.readLine()) != null) {
            if (!aLine.trim().startsWith("-") && aLine.trim().length() > 0) {
                lista.add(aLine);
                i++;
            }
        }
        Collections.sort(lista);
        for (String s : lista) {
            escritor.write(s);
            escritor.newLine();
        }
        lector.close();
        escritor.close();
    }
}
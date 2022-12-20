import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class apartadoA {
    public static void main(String[] args) throws IOException {

        BufferedReader fichero=null;
        try {
            fichero = new BufferedReader(new FileReader("src/carpetas.txt"));
            String linea = fichero.readLine();

            while (linea != null){
                File d = new File(linea); //directorio creado con el nombre leido
                d.mkdir();
                linea = fichero.readLine();
            }
            fichero.close();
        }catch (Exception e){
            System.out.println("error");
        }
        }
    }
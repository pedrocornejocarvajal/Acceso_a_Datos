package DAL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejadoraBBDD {
    public static Statement statement = null;

    public static void main(String[] args) {


        Connection connection = ConexionBBDD.abrirConexion();


        try {
            statement = connection.createStatement();

//          Creaciones de tablas
            crearTabla("Personas", new String[]{"idPersona INT Primary Key AUTO_INCREMENT", "nombre VARCHAR(25)", "saldo DECIMAL(10,2)"});
            crearTabla("Sorteos", new String[]{"numSorteo INT Primary Key AUTO_INCREMENT", "recaudacion DECIMAL(10,2)", "bote DECIMAL(10,2)", "num1 INT", "num2 INT", "num3 INT"});
            crearTabla("Apuestas", new String[]{"idApuesta INT Primary Key AUTO_INCREMENT", "numSorteo INT ", "idPersona INT", "numero INT", "Foreign Key (numSorteo) REFERENCES Sorteos(numSorteo) ON DELETE CASCADE ON UPDATE CASCADE", "Foreign Key (idPersona) REFERENCES Personas(idPersona) ON DELETE CASCADE ON UPDATE CASCADE"});
//          Fin de creaciones de tablas


            //Insertar datos en tablas
            String ficheroMesa = "src\\DAL\\FicherosDatos\\ad2223.pcornejo.Personas.sql";

            insertarDatosConFicheroSql(ficheroMesa);
            //Fin de insertar Datos en tablas

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Descripcion: Metodo para crear una tabla SQL segun un nombre y unos campos metidos por parametros
     * Precondiciones: La base de datos existe y estamos conectados a ella
     * Postcondiciones: La tabla ha sido creada correctamente
     *
     * @param nombreTabla
     * @param nombresCampo
     */

    private static void crearTabla(String nombreTabla, String[] nombresCampo) {

        String sql = "CREATE TABLE ad2223_pcornejo." + nombreTabla + " (";
        for (int i = 0; i < nombresCampo.length; i++) {
            sql += nombresCampo[i];
            if (i != nombresCampo.length - 1) {
                sql += ",";
            }
        }
        sql += ");";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para borrar una tabla SQL de una Base de Datos
     * Precondiciones: La tabla debe de existir en la base de datos
     * postcondiciones: La tabla ha sido borrada correctamente
     *
     * @param nombreTabla
     */

    private static void borrarTabla(String nombreTabla) {
        String sql = "DROP TABLE ad2223.pcornejo." + nombreTabla;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para insertar datos en nuestra base de datos mediante un archivo SQL
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     */

    private static void insertarDatosConFicheroSql(String nombreFichero) {

        try {
            String linea;
            BufferedReader bf = new BufferedReader(new FileReader(nombreFichero));
            while ((linea = bf.readLine()) != null) {

                statement.executeUpdate(linea);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Descripcion: Metodo para borrar los registros de una tabla introducida por parametros
     * Precondicion: La tabla existe
     * Postcondicion: Los registros han sido borrados correctamente
     */
    public static void borrarRegistros(String nombreTabla) {

        String sql = "DELETE FROM ad2223.pcornejo." + nombreTabla;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Descripcion: Metodo para crear una tabla SQL segun un nombre y unos campos metidos por parametros
     * Precondiciones: La base de datos existe y estamos conectados a ella
     * Postcondiciones: La tabla ha sido creada correctamente
     *
     * @param nombreTabla
     * @param nombresCampo
     */


    private static void insertarDatosPorParametros(String nombreTabla, String[] nombresCampo) {

        String sql = "INSERT INTO ad2223_pcornejo." + nombreTabla + " (";
        for (int i = 0; i < nombresCampo.length; i++) {
            sql += nombresCampo[i];
            if (i != nombresCampo.length - 1) {
                sql += ",";
            }
        }
        sql += ");";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

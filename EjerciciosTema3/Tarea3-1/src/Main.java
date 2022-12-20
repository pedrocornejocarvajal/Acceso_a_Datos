import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    private static final String urlConnection = "jdbc:mysql://dns11036.phdns11.es";
    private static final String user = "ad2223_pcornejo";
    private static final String password = "1234";

    public static Statement statement = null;

    public static void main(String[] args) {


        Connection connection = crearConexion();
        try {
            statement = connection.createStatement();

//            //Creaciones de tablas
            crearTabla("Mesa", new String[]{"idMesa INT Primary Key AUTO_INCREMENT", "numComensales INT", "reserva TINYINT"});
            crearTabla("Productos", new String[]{"idProducto INT Primary Key AUTO_INCREMENT", "denominacion VARCHAR(45)", "precio DECIMAL(10,2)"});
            crearTabla("Facturas", new String[]{"idFactura INT Primary Key AUTO_INCREMENT", "idMesa INT ", "tipoPago VARCHAR(45)", "importe DECIMAL(10,2)", "Foreign Key (idMesa) REFERENCES Mesa(idMesa) ON DELETE CASCADE ON UPDATE CASCADE"});
            crearTabla("Pedido", new String[]{"idPedido INT Primary Key AUTO_INCREMENT", "idFactura INT", "idProducto INT ", "cantidad INT", "Foreign Key (idFactura) REFERENCES Facturas(idFactura) ON DELETE CASCADE ON UPDATE CASCADE", "Foreign Key (idProducto) REFERENCES Productos(idProducto) ON DELETE CASCADE ON UPDATE CASCADE"});
            //Fin de creaciones de tablas


//            //Insertar datos en tablas
            String ficheroMesa = "src\\Datos\\ad2223.pcornejo.Mesa.sql";
            String ficheroProductos = "src\\Datos\\ad2223.pcornejo.Productos.sql";
            String ficheroFacturas = "src\\Datos\\ad2223.pcornejo.Facturas.sql";
            String ficheroPedido = "src\\Datos\\ad2223.pcornejo.Pedido.sql";

            insertarDatos(ficheroMesa);
            insertarDatos(ficheroProductos);
            insertarDatos(ficheroFacturas);
            insertarDatos(ficheroPedido);
//            //Fin de insertar Datos en tablas

//
//            //listar los datos insertados
//            listar("Select * from ad2223_pcornejo.Mesa", new String[]{"idMesa", "numComensales"});
//            //Fin de listar
//
//
//            //Borrar Tablas de las bases de datos
//
//            String tablaMesa = "ad2223.pcornejo.Mesa";
//            String tablaProductos = "ad2223.pcornejo.Productos";
//            String tablaFacturas = "ad2223.pcornejo.Facturas";
//            String tablaPedidos = "ad2223.pcornejo.Pedido";
//
//            borrarTabla(tablaMesa);
//            borrarTabla(tablaProductos);
//            borrarTabla(tablaFacturas);
//            borrarTabla(tablaPedidos);
//            //Fin de borrar las tablas

            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para crear la conexion con la base de datos
     * Precondiciones: La base de datos debe de existir
     * Postcondiciones: La conexion con la base de datos ha sido realizada
     *
     * @return
     */
    private static Connection crearConexion() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(urlConnection, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
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
        String sql = "DROP TABLE ad2223." + nombreTabla;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para insertar datos en nuestra base de datos
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     */

    private static void insertarDatos(String nombreFichero) {

        try {
            String linea;
            BufferedReader bf = new BufferedReader(new FileReader(nombreFichero));
            while ((linea = bf.readLine() )!= null) {

                statement.executeUpdate(linea);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para leer un archivo y guardar la informacion en un array
     * Precondicion: Se le pasa por parametro un fichero existente
     * Postcondicion: Devuelve una lista con los datos del archivo
     */

    private static ArrayList<String> leerFichero(File fichero){
        ArrayList<String> lista = new ArrayList();
        FileReader fr = null;
        BufferedReader br;

        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace(System.out);
            }
        }
        return lista;
    }

    /**
     * Descripcion: Metodo para insertar datos en nuestra base de datos
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     * @param nombreTabla
     * @param campos
     * @param condicion
     */
        public void modificar(String nombreTabla, String campos, String condicion){// Metodo para modificar
            try{

                statement.executeUpdate("UPDATE ad2223."+ nombreTabla + "SET " + campos + "WHERE " + condicion);//Consulta
                System.out.println("Actualizacion Exitosa");
            }
            catch (Exception e){//En caso de error
                e.printStackTrace();
            }
        }


    /**
     * Descripcion: Metodo para listar o ejecutar una sentencia sql según una sentencia y unos campos metidos por parametros
     *
     * @param sql
     * @param campos
     */

    private static void listar(String sql, String[] campos) {
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                for (String campo : campos) {
                    System.out.print(rs.getString(campo) + "\t\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


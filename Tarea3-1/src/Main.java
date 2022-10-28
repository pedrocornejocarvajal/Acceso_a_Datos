import java.sql.*;

public class Main {
    private static final String urlConnection = "jdbc:mysql://dns11036.phdns11.es";
    private static final String user = "pcornejo";
    private static final String password = "pcornejo";

    public static Statement statement = null;

    public static void main(String[] args) {


        Connection connection = crearConexion();
        try {
            statement = connection.createStatement();

            //Creaciones de tablas
            crearTabla("Mesa", new String[]{"idMesa INT Primary Key AUTO_INCREMENT", "numComensales INT", "reserva TINYINT"});
            crearTabla("Productos", new String[]{"idProducto INT Primary Key AUTO_INCREMENT", "denominacion VARCHAR(45)", "precio DECIMAL(10,2)"});
            crearTabla("Factura", new String[]{"idFactura INT Primary Key AUTO_INCREMENT", "idMesa INT ", "tipoPago VARCHAR(45)", "importe DECIMAL(10,2)", "Foreign Key (idMesa) REFERENCES Mesa(idMesa)"});
            crearTabla("Pedido", new String[]{"idPedido INT Primary Key AUTO_INCREMENT", "idFactura INT", "idProducto INT ", "cantidad INT", "Foreign Key (idFactura) REFERENCES Factura(idFactura)", "Foreign Key (idProducto) REFERENCES Productos(idProducto)"});
            //Fin de creaciones de tablas


            //Insertar datos en tablas

            //Fin de insertar Datos en tablas



            //listar los datos insertados

            //Fin de listar


            //Borrar Tablas de las bases de datos

            //Fin de borrar las tablas

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
        //String[] campos = {"ID int Primary Key AUTO_INCREMENT","nombre varchar(255)","apellidos varchar(255)","edad int"};
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
     * Descripcion: Metodo para insertar datos de las mesas en nuestra base de datos
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     */

    private static void insertarDatosMesas() {

        //TODO hacerlo desde ficheros xml
        String[] datos = {"insert into ad2223_pcornejo.Mesa (idMesa, numComensales, reserva) values ('1', '4', 6)"};
        try {
            for (String sql : datos) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para insertar datos de los Productos en nuestra base de datos
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     */

    private static void insertarDatosProductos() {

        //TODO hacerlo desde ficheros xml
        String[] datos = {"insert into ad2223_pcornejo.Mesa (idMesa, numComensales, reserva) values ('Reuben', 'Tommasetti', 15)"};
        try {
            for (String sql : datos) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para insertar datos de las Facturas en nuestra base de datos
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     */

    private static void insertarDatosFacturas() {

        //TODO hacerlo desde ficheros xml
        String[] datos = {"insert into ad2223_pcornejo.Mesa (idMesa, numComensales, reserva) values ('Reuben', 'Tommasetti', 15)"};
        try {
            for (String sql : datos) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Descripcion: Metodo para insertar datos de los Pedidos en nuestra base de datos
     * Precondicion: La tabla existe
     * Postcondicion: Lo datos han sido insertados correctamente
     */

    private static void insertarDatosPedidos() {

        //TODO hacerlo desde ficheros xml
        String[] datos = {"insert into ad2223_pcornejo.Mesa (idMesa, numComensales, reserva) values ('Reuben', 'Tommasetti', 15)"};
        try {
            for (String sql : datos) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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


import java.sql.*;

public class Main {


    private static final String urlConnection = "jdbc:mysql://dns11036.phdns11.es/ad2223_neptuno";
    private static final String user = "ad2223_neptuno";
    private static final String password = "nervion";

    public static Statement statement = null;
    public static void main(String[] args) {


        Connection connection = crearConexion();

        try {
            statement = connection.createStatement();
//            listar("SELECT * FROM Clientes", new String[]{"NombreCompañia","NombreContacto","Ciudad"});

//            listar("SELECT * FROM Clientes ORDER BY CodPostal desc, Direccion desc",new String[]{"NombreContacto","Direccion","CodPostal"});
            muestraListado("SELECT Productos.NombreProducto, Categorias.NombreCategoria, Productos.PrecioUnidad FROM Productos INNER JOIN Categorias ON Productos.IdCategoria = Categorias.IdCategoria ORDER BY Categorias.NombreCategoria , Productos.NombreProducto  ",3);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

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

    private static void muestraListado(String sql, int numCampos) {
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                for (int i = 1; i <= numCampos; i++) {
                    System.out.print(rs.getString(i) + "\t||\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
import java.sql.*;

public class Conexion {

    private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Statement st_ = null;
    private static Connection connection_;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(servidor, "ad2223", "nervion");

            if (connection_ !=null){
                st_ = connection_.createStatement();
                System.out.println("Conexion a base de datos test correcta");
                System.out.println(st_.toString());
            } else {
                System.out.println("conexion fallida .");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        String[] campos = "id varchar(50) NOT NULL, nombre varchar(50),apellido varchar(50), edad INT(20))";
        crearTabla("pcornejo", campos);

    }
//
//    public static ResultSet crearDatos (){
//
//        try {
//            st_ = connection_.prepareStatement("CREATE TABLE ad2223.persona (id varchar(50) NOT NULL, nombre varchar(50),apellido varchar(50), edad INT(20))");
//            st_.execute("CREATE TABLE ad2223.persona (id varchar(50) NOT NULL, nombre varchar(50),apellido varchar(50), edad INT(20)");
//            st_.close();
//        } catch (SQLException sqle) {
//            System.out.println("Error en la ejecución: "
//                    + sqle.getErrorCode() + " " + sqle.getMessage());
//        }
//
//        return (ResultSet) st_;
//    }

    private static void crearTabla(String nombreTabla, String[] campos){

        String sql = "CREATE TABLE ad2223." +nombreTabla + " (" ;

        for (int i = 0; i < campos.length; i++) {
            sql += campos[i];
            if (i< campos.length-1){
                sql+=",";
            }
        }
        sql +=");";

        try {
            st_.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
package DAL;

import Entidades.*;

import java.sql.*;
import java.util.ArrayList;

public class ManejadoraEntidadesBBDD {

    public static Statement statement = null;

    /**
     * Descripcion: metodo que recoge el listado completo de personas en la BBDD
     * Prercondiciones: debe existir la tabla personas dentro de la base de datos
     * Postcondiciones: ninguna
     *
     * @return personas
     */
    public static ArrayList<Persona> getListadoPersonas() {
        Connection cnn = null;
        ArrayList<Persona> personas = new ArrayList<>();
        PreparedStatement Psttmnt = null;
        try {
            cnn = ConexionBBDD.abrirConexion();
            cnn.setAutoCommit(false);
            Psttmnt = cnn.prepareStatement("Select * From ad2223pcornejo.Personas");
            ResultSet result = Psttmnt.executeQuery();
            personas.add(new Persona(result.getInt(1), result.getString(2), result.getDouble(3)));
            cnn.commit();
        } catch (SQLException e) {
            System.out.println("Error de Acceso a la Base de Datos o Conexion no Inicializada.");
        } finally {
            if (cnn != null) {
                ConexionBBDD.cerrarConexion(cnn);

            }
        }
        return personas;
    }


    /**
     * Descripcion: metodo que recoge el listado completo de los sorteos que hay en la BBDD
     * Prercondiciones: debe existir la tabla personas dentro de la base de datos
     * Postcondiciones: ninguna
     *
     * @return sorteos
     */
    public static ArrayList<Sorteo> getListadoSorteos() {
        Connection cnn = null;
        ArrayList<Sorteo> sorteos = new ArrayList<>();
        PreparedStatement Psttmnt = null;
        try {
            cnn = ConexionBBDD.abrirConexion();
            cnn.setAutoCommit(false);
            Psttmnt = cnn.prepareStatement("Select * From ad2223pcornejo.Sorteos");
            ResultSet result = Psttmnt.executeQuery();
            sorteos.add(new Sorteo(result.getInt(1), result.getDouble(2), result.getDouble(3), result.getInt(4), result.getInt(5), result.getInt(6)));
            cnn.commit();
        } catch (SQLException e) {
            System.out.println("Error de Acceso a la Base de Datos o Conexion no Inicializada.");
        } finally {
            if (cnn != null) {
                ConexionBBDD.cerrarConexion(cnn);

            }
        }
        return sorteos;
    }


    /**
     * Descripcion: metodo que recoge el listado completo de las apuestas que hay en la BBDD
     * Prercondiciones: debe existir la tabla personas dentro de la base de datos
     * Postcondiciones: ninguna
     *
     * @return apuestas
     */
    public static ArrayList<Apuesta> getListadoApuestas() {
        Connection cnn = null;
        ArrayList<Apuesta> apuestas = new ArrayList<>();
        PreparedStatement Psttmnt = null;
        try {
            cnn = ConexionBBDD.abrirConexion();
            cnn.setAutoCommit(false);
            Psttmnt = cnn.prepareStatement("Select * From ad2223pcornejo.Apuestas");
            ResultSet result = Psttmnt.executeQuery();
            apuestas.add(new Apuesta(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)));
            cnn.commit();
        } catch (SQLException e) {
            System.out.println("Error de Acceso a la Base de Datos o Conexion no Inicializada.");
        } finally {
            if (cnn != null) {
                ConexionBBDD.cerrarConexion(cnn);

            }
        }
        return apuestas;
    }

}



import java.sql.*;

public class Main {

    private static final String urlConnection = "jdbc:mysql://dns11036.phdns11.es";
    private static final String user = "ad2223";
    private static final String password = "nervion";
    public static Connection connection = crearConexion();
    public static Statement statement = null;

    public static void main(String[] args) {
        try {
            statement = connection.createStatement();

//            crearTabla("pcornejo", new String[] {"ID int Primary Key AUTO_INCREMENT","nombre varchar(255)","apellidos varchar(255)","edad int"});
 //           insertarIntoTable();
            //Listado ordenado por edad.
//            muestraListado("Select * from ad2223.pcornejo ORDER BY edad", new String[]{"nombre", "apellidos", "edad"});
            //Listado de los nombres y apellidos ordenados por apellido.
//            muestraListado("Select * from ad2223.pcornejo ORDER BY apellidos", new String[]{"nombre", "apellidos"});
            //Listado de nombres y apellidos de más de 30 años
//            muestraListado("Select * from ad2223.pcornejo WHERE edad > 30", new String[]{"nombre", "apellidos"});
            //Listado de los nombres que comiencen por "J" ordenados por apellido.
//            muestraListado("Select * from ad2223.pcornejo WHERE nombre LIKE 'J%' ORDER BY apellidos", new String[]{"nombre"});
            //Listado de los nombres que comiencen por "C" y los apellidos por "A" ordenados por edad de mayor a menor.
//            muestraListado("Select * from ad2223.pcornejo WHERE nombre LIKE 'C%' AND apellidos LIKE 'A%' ORDER BY edad desc", new String[]{"nombre"});
            //Media de edad de la muestra.
//            muestraListado("Select AVG(edad) as Media from ad2223.pcornejo", new String[]{"Media"});
            //Listado de los apellidos que contengan las letras "oh" o las letras "ma" (si el resultado fuera nulo, cambiar las letras)
//            muestraListado("Select * from ad2223.pcornejo WHERE apellidos LIKE '%oh%' OR apellidos LIKE '%ma%'", new String[]{"apellidos"});
            //Listado de las personas en la franja de edad comprendida entre los 24 y los 32 años.
//            muestraListado("Select * from ad2223.pcornejo WHERE edad BETWEEN 24 AND 32", new String[]{"nombre","apellidos","edad"});
            //Listado de las personas mayores de 65 años.
//            muestraListado("Select * from ad2223.pcornejo WHERE edad > 65", new String[]{"nombre", "apellidos", "edad"});
            //Crea una columna denominada "laboral" que contendrá los siguientes valores: estudiante, ocupado, parado, jubilado.
//            updateTabla("ALTER TABLE ad2223.pcornejo ADD laboral varchar(255)");
//            //Actualiza la columna laboral con el siguiente criterio:
//            //  Los menores de 18 son estudiantes
//            updateTabla("UPDATE ad2223.pcornejo SET laboral = 'Estudiantes' WHERE edad < 18");
//            //  Los mayores de 65 son jubilados
//            updateTabla("UPDATE ad2223.pcornejo SET laboral = 'Jubilados' WHERE edad > 65");
//            //  Los de edad impar, que no pertenezcan a los colectivos anteriores, están parados
//            updateTabla("UPDATE ad2223.pcornejo SET laboral = 'Parados' WHERE edad BETWEEN 18 AND 65 and mod(edad,2) <> 0");
//            //  El resto, ocupados
//           updateTabla("UPDATE ad2223.pcornejo SET laboral = 'Ocupados' WHERE laboral IS NULL");

//            muestraListadoPorInicialNombre("j", new String[]{"nombre"});

  //          muestraListadoPorInicialNombreYApellidos("c", "a", new String[]{"nombre", "apellidos"} );

            muestraListadoEntreEdades(10,52, new String[]{"nombre", "apellidos", "edad"});

            statement.close();
            connection.close();
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

    private static void crearTabla(String nombreTabla, String[] nombresCampo) {
        //String[] campos = {"ID int Primary Key AUTO_INCREMENT","nombre varchar(255)","apellidos varchar(255)","edad int"};
        String sql = "CREATE TABLE ad2223." + nombreTabla + " (";
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

    private static void borrarTabla(String nombreTabla) {
        String sql = "DROP TABLE ad2223." + nombreTabla;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void insertarIntoTable() {
        //private static void insertarIntoTable(String[] datos)
        //TODO hacerlo desde ficheros xml
        String[] datos = {"insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Reuben', 'Tommasetti', 15)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Leyla', 'Gambell', 31)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Hanna', 'Colegate', 80)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Evvy', 'Jeannel', 99)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Gwenny', 'Mundow', 43)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Beilul', 'Keely', 46)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Hurley', 'Kingswoode', 98)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Darcey', 'O''Scollee', 49)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Chip', 'McNay', 89)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bonnie', 'Grainger', 26)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lalo', 'Pickerin', 52)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bancroft', 'Sauvage', 13)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Korella', 'Fulep', 16)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Carlynne', 'Stienton', 50)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lilia', 'Calf', 14)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ivy', 'Staddom', 13)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Aldin', 'Oluwatoyin', 76)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Florance', 'Bugler', 31)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Andrew', 'Curd', 36)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ranice', 'Ackred', 79)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bondy', 'Carnachen', 100)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Chrisy', 'Ridolfi', 35)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ardyce', 'Strainge', 31)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Deb', 'Cuerdall', 69)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Brigham', 'Dawid', 54)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Cherye', 'Twizell', 54)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Letta', 'Yetton', 49)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Querida', 'Shaves', 29)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Carlos', 'Rubberts', 71)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Archy', 'Haversum', 59)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lynnell', 'Wick', 34)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Vera', 'Spenclay', 40)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Kenon', 'Roxburch', 68)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lucretia', 'Kleeman', 82)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Neda', 'Norville', 67)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Nataniel', 'Scrange', 99)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Aryn', 'Puddle', 70)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Reba', 'Nunns', 13)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Tally', 'Hutfield', 21)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Reine', 'Scadding', 54)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Javier', 'Fuggle', 88)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Wilfred', 'Sidary', 79)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Sanderson', 'Heggie', 99)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Chiquita', 'O''Shesnan', 23)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Dedie', 'Gumby', 24)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Frank', 'Brodnecke', 84)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Buddie', 'Managh', 55)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Curran', 'Dormer', 44)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Amy', 'Coskerry', 56)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ian', 'Addenbrooke', 30)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Wilek', 'Godfray', 49)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lavinia', 'Spur', 92)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Zerk', 'Planks', 37)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Farah', 'Zimmerman', 44)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Etta', 'Geffen', 18)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jami', 'Brixey', 45)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Alejandrina', 'Gatheridge', 15)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Stavro', 'Gettins', 57)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Madge', 'MacNeilage', 95)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Christal', 'Farnall', 55)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Laurella', 'Mayers', 99)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Clevie', 'Leist', 45)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Nelson', 'McNess', 22)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jeanelle', 'Lympany', 97)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Derron', 'Antram', 32)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Merline', 'Basnett', 55)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Tod', 'Mawdsley', 71)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jehanna', 'Ayshford', 63)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Auberta', 'Lyptratt', 55)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Hyacintha', 'Windridge', 20)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bearnard', 'Tappor', 99)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Kissee', 'Longwood', 81)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Muriel', 'Henaughan', 17)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Louise', 'Haack', 80)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Kincaid', 'Fonte', 85)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Sally', 'Adamou', 54)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Floyd', 'Gabbitas', 14)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Tracy', 'Daymond', 12)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Herby', 'Alvaro', 42)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('El', 'Gerriet', 62)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Gearalt', 'Troughton', 21)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Darci', 'Karchowski', 23)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Vidovic', 'Lisciandri', 37)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bobbe', 'Simononsky', 56)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Hayward', 'De Biasi', 17)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Agnella', 'Conyers', 28)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Alexei', 'Brake', 15)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Carie', 'Chetham', 22)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Mufi', 'Ravilus', 54)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Seumas', 'Attrie', 85)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Alexa', 'Bainbrigge', 88)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Alexandros', 'Spillman', 66)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Maryjane', 'Twelftree', 88)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Nettie', 'Tayloe', 33)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bentlee', 'Fluin', 66)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ernesto', 'Willerson', 70)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Vasilis', 'Biaggiotti', 27)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Cyrille', 'Klemensiewicz', 14)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bridget', 'Clarkson', 24)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Addia', 'Moraleda', 65)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lil', 'Standbrook', 96)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Esme', 'Long', 19)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Merilee', 'Dinning', 92)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Hannie', 'Josephs', 94)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Sholom', 'Croot', 19)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Christoforo', 'Ianniello', 14)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Christye', 'Goane', 20)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ozzy', 'Vasiljevic', 67)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Alanah', 'MacIlwrick', 41)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Madelin', 'Roden', 41)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Walsh', 'Best', 65)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Kora', 'Lunge', 35)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Malinda', 'Tompion', 59)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Emlyn', 'Beardwood', 95)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Patricio', 'Albrecht', 42)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Lynnea', 'Ballston', 49)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Sula', 'Shivlin', 25)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Joyan', 'Fritchly', 59)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Anton', 'Steiner', 78)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Dot', 'Niaves', 87)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bryce', 'Lafay', 19)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Georg', 'Elsmore', 87)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jany', 'Barrar', 70)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Timothy', 'Kiggel', 92)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Manolo', 'Bussell', 93)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Niven', 'Witsey', 23)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Adan', 'Loughlan', 12)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Dena', 'Ginner', 56)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Valentia', 'Stafford', 55)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Piggy', 'Franzelini', 45)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jeana', 'Burt', 76)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Sybil', 'MacCrachen', 24)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Danny', 'Hamor', 14)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Burt', 'Barford', 98)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Zarah', 'Squier', 37)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Noelle', 'Bogace', 26)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Noelyn', 'Maslen', 97)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Clevey', 'Corah', 56)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Nicolas', 'Hancock', 33)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Staffard', 'Ashton', 23)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Stanton', 'Forgie', 79)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Domini', 'Walsh', 65)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Currey', 'Wallbank', 27)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Amos', 'Markham', 80)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Igor', 'Gwin', 71)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Joice', 'Tuxsell', 93)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Reggy', 'MacMarcuis', 95)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Rachelle', 'Bruin', 59)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Johanna', 'Bindin', 12)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Armin', 'Cobbin', 61)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Ingra', 'Mulles', 16)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Briant', 'Quant', 38)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Danit', 'Ducket', 96)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Herc', 'Fisk', 63)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Odie', 'Mattecot', 97)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Dona', 'Sweetmore', 100)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Gianna', 'Bradock', 79)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Angeli', 'Bastone', 27)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Vannie', 'Ponton', 36)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Kent', 'Jacke', 65)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Gaultiero', 'Southern', 96)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Abel', 'Burwood', 99)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Mattias', 'Pittaway', 51)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Hewitt', 'Riceards', 100)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Marigold', 'Lafont', 68)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Dean', 'Hecks', 28)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Fifi', 'Fryer', 56)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Byran', 'Cresar', 53)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jolie', 'Alcalde', 27)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Manya', 'Brazelton', 33)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Veda', 'Hammersley', 61)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Herbie', 'Woloschinski', 32)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Marris', 'Whieldon', 63)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Andrej', 'Sapp', 70)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Remington', 'Demaine', 62)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Felike', 'Cerie', 37)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Cathi', 'Greenlies', 84)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jimmie', 'Shirtcliffe', 96)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Cher', 'Glanz', 12)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Robb', 'Maloney', 33)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Cord', 'Shortall', 63)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Jobye', 'Brassington', 29)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Paco', 'Riccetti', 27)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Emelyne', 'Warbrick', 46)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Louise', 'Foystone', 94)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Alma', 'Scarratt', 67)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Dar', 'Tiebe', 37)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Gris', 'Ragles', 53)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Roxie', 'Endacott', 19)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Clare', 'Skae', 87)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Greg', 'Snelson', 88)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Katinka', 'Humby', 74)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Bil', 'Dilloway', 86)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Mikel', 'Parfett', 12)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Sela', 'Schiefersten', 38)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Foss', 'Creasy', 80)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Charissa', 'Chawkley', 84)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Emelita', 'Pesterfield', 30)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Fielding', 'Floyed', 24)",
                "insert into ad2223.pcornejo (nombre, apellidos, edad) values ('Tallou', 'Mouncher', 75)"};
        try {
            for (String sql : datos) {
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void muestraListado(String sql, String[] campos) {
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

    private static void muestraListadoPorInicialNombre(String inicial, String[] campos) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ad2223.pcornejo WHERE nombre LIKE ? ");
            preparedStatement.setString(1, inicial+"%");
            ResultSet rs = preparedStatement.executeQuery();
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

    private static void muestraListadoPorInicialNombreYApellidos(String inicialNombre,String inicialApellido, String[] campos) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ad2223.pcornejo WHERE nombre LIKE ? AND apellidos LIKE ? ORDER BY edad desc");
            preparedStatement.setString(1, inicialNombre+"%");
            preparedStatement.setString(2,  inicialApellido+"%");
            ResultSet rs = preparedStatement.executeQuery();
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

    private static void muestraListadoEntreEdades(int menor,int mayor, String[] campos) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ad2223.pcornejo WHERE edad BETWEEN ? AND ? ORDER BY edad desc");
            preparedStatement.setInt(1, menor);
            preparedStatement.setInt(2,  mayor);
            ResultSet rs = preparedStatement.executeQuery();
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



    private static void updateTabla(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final String SQL_TABLE_CREATE_ODONTOLOGOS =  "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (" +
            "NUMEROMATRICULA INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL" +
            ")";

    // Conexion BD
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./2402",
                "sa", "sa");
    }

    public static void crearTablas() {
        Connection connection = null;

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE_ODONTOLOGOS);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aceasta clasa se ocupa cu stabilirea unei conexiuni la baza de date.
 */
public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/pfa_ps?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "asd123ASD!@#";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aceasta metoda creaza o conexiunea la baza de date
     * iar in cazul in care aceasta nu poate fi creata
     * trimite un mesaj de eroare.
     *
     * @return Connection Conexiunea creata.
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Aceasta metoda este folosita pentru a returna
     * conexiunea la baza de date.
     *
     * @return Connection Conexiunea la baza de date.
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Aceasta metoda este utilizata pentru a incheia
     * conexiunea cu baza de date.
     *
     * @param connection Conexiunea care trebuie incheiata.
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Aceasta metoda este utilizata pentru
     * a termina o interogare la baza de date.
     *
     * @param statement Interogarea care trebuie terminata.
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Aceasta metoda este utilizata pentru incheia un set
     * de rezultate.
     *
     * @param resultSet Setul de rezultate care trebuie incheiat.
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
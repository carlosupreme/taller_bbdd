package app;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;
import views.MessageHandler;

public class MySQLConnection {

    private static MySQLConnection instance = null;
    private Connection conn = null;

    private MySQLConnection() {
        try {
            Dotenv dotenv = Dotenv.configure().load();

            String url = String.format("jdbc:mysql://%s:%s/%s", dotenv.get("DB_HOST"), dotenv.get("DB_PORT"), dotenv.get("DB_DATABASE"));

            conn = DriverManager.getConnection(url, dotenv.get("DB_USERNAME"), dotenv.get("DB_PASSWORD"));
        } catch (SQLException e) {
            MessageHandler.showErrorMessage("El servidor de MySQL no está funcionando");
        }
    }

    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

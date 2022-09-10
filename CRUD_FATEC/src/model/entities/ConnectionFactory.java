package model.entities;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {
    private String host = "localhost";
    private String port = "3306";
    private String db = "db_aula_bossini";
    private String user = "root";
    private String password = "12345";

    public Connection getConnection() throws Exception{
        return DriverManager.getConnection(
            String.format(
                "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC",
                host,
                port,
                db
            ),
            user,
            password
        );
    }
}


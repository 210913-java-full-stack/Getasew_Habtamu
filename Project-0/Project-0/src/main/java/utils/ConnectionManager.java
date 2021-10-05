package utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager
{
    private static Connection conn;

    private ConnectionManager()
    {

    }

    public static Connection getConnection() throws IOException, SQLException
    {
        if(conn == null)
        {
            Properties props = new Properties();

            FileReader connProperties = new FileReader("src/main/resources/connection.properties");
            props.load(connProperties);

            //"jdbc:mariadb://hostname:port/databaseName?user=username&password=password"
            String connectionString = "jdbc:mariadb://"
                    + props.getProperty("hostname")
                    + ":" + props.getProperty("port")
                    + "/" + props.getProperty("databaseName")
                    + "?user=" + props.getProperty("user")
                    + "&password=" + props.getProperty("password");

            //This will get the connection form property//
            conn = DriverManager.getConnection(connectionString);
        }


        return conn;
    }

}
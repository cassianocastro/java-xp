package dataBaseIntegration;

import java.sql.*;

/**
 *
 */
public class ConnectionFactory
{

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:src/lib/db.sqlite");
    }
}

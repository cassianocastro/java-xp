package dataBaseIntegration;
import java.sql.*;

/**
 * Fábrica de Conexões com a Base de Dados "exemplo".
 * @author cassiano
 */
public class ConnectionFactory{

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/exemplo", "root", "");
        }catch( SQLException e ){
            throw new RuntimeException(e);
        }

    }
}
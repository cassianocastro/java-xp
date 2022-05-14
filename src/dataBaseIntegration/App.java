/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseIntegration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 *
 */
public class App
{

    public void start()
    {
        Connection connection = this.connect();

        new CRUDTest(connection).test();
    }

    private Connection connect()
    {
        try
        {
            return new ConnectionFactory().getConnection();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

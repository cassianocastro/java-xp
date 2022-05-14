/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseIntegration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 */
public class CRUDTest
{

    private final Connection connection;

    public CRUDTest(Connection connection)
    {
        this.connection = connection;
    }

    public void test()
    {
        try
        {
            // this.testInsert();
            this.testRead();
            // this.testSearch();
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void testInsert() throws SQLException
    {
        String name        = JOptionPane.showInputDialog("Nome:");
        String email       = JOptionPane.showInputDialog("E-mail:");
        String address     = JOptionPane.showInputDialog("Endereço:");
        Calendar birthDate = Calendar.getInstance();

        new ContactDAO(connection).insert(new Contact(0L, name, email, address, birthDate));

        System.out.println("Recorded!!");
    }

    private void testRead() throws SQLException
    {
        StringBuilder msg          = new StringBuilder();
        ContactFormatter formatter = new ContactFormatter();
        List<Contact> list         = new ContactDAO(connection).read();

        for ( Contact contact : list )
        {
            msg.append(formatter.formatDataFrom(contact));
        }
        System.out.println(msg);
    }

    private void testSearch() throws SQLException
    {
        Long ID = Long.parseLong(JOptionPane.showInputDialog("ID:"));
        Contact contact = new ContactDAO(connection).findByID(ID);

        System.out.println(new ContactFormatter().formatDataFrom(contact));
    }

}

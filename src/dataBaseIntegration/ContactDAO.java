package dataBaseIntegration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class ContactDAO
{

    private final Connection connection;

    public ContactDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(Contact contact) throws SQLException
    {
        PreparedStatement statement = this.connection.prepareStatement(
            "INSERT INTO contact(name, email, address, birthDate) VALUES (?, ?, ?, ?)"
        );
        statement.setString(1, contact.getName());
        statement.setString(2, contact.getEmail());
        statement.setString(3, contact.getAddress());
        statement.setDate(4, new Date(contact.getBirthDate().getTimeInMillis()));

        statement.execute();
    }

    public List read() throws SQLException
    {
        PreparedStatement statement = this.connection.prepareStatement(
            "SELECT id, name, email, address, birthDate FROM contact"
        );
        ResultSet rs = statement.executeQuery();
        List<Contact> list = new ArrayList<>();

        while ( rs.next() )
        {
            Long id            = rs.getLong("id");
            String name        = rs.getString("name");
            String email       = rs.getString("email");
            String address     = rs.getString("address");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(rs.getDate("birthDate"));

            list.add(new Contact(id, name, email, address, birthDate));
        }

        return list;
    }

    public Contact findByID(Long ID) throws SQLException
    {
        PreparedStatement statement = this.connection.prepareStatement(
            "SELECT id, name, email, address, birthDate FROM contact WHERE id = ?"
        );
        statement.setString(1, ID.toString());
        ResultSet rs = statement.executeQuery();

        if ( rs.next() )
        {
            Long id            = rs.getLong("id");
            String name        = rs.getString("name");
            String email       = rs.getString("email");
            String address     = rs.getString("address");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(rs.getDate("birthDate"));

            return new Contact(id, name, email, address, birthDate);
        }

        throw new SQLException("Contact not found!");
    }

    public void update(Contact contact) throws SQLException
    {
        PreparedStatement statement = this.connection.prepareStatement(
            "UPDATE contact SET name = ?, email = ?, address = ?, birthDate = ? WHERE id = ?"
        );
        statement.setString(1, contact.getName());
        statement.setString(2, contact.getEmail());
        statement.setString(3, contact.getAddress());
        statement.setDate(4, new Date(contact.getBirthDate().getTimeInMillis()));
        statement.setLong(5, contact.getID());

        statement.execute();
    }

    public void delete(Contact contact) throws SQLException
    {
        PreparedStatement statement = this.connection.prepareStatement(
            "DELETE FROM contact WHERE id = ?"
        );
        statement.setLong(1, contact.getID());

        statement.execute();
    }
}

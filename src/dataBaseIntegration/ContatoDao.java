package dataBaseIntegration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author cassiano
 */
public class ContatoDao {

    private Connection connection;

    public ContatoDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Contato contato) {
        String sql = "INSERT INTO contatos "
                + "( nome, email, endereco, data_nascimento )"
                + "values"
                + "( ?, ?, ?, ? )";
        try (PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setDate  (4, new Date(contato.getData_nascimento().getTimeInMillis()));
            statement.execute  ();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List read() {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        try ( PreparedStatement statement = this.connection.prepareStatement(sql);
              ResultSet resultSet = statement.executeQuery())
        {  
            while (resultSet.next()) {
                Long id            = resultSet.getLong("id");
                String nome        = resultSet.getString("nome");
                String email       = resultSet.getString("email");
                String endereco    = resultSet.getString("endereco");
                Calendar data_nasc = Calendar.getInstance();
                data_nasc.setTime(resultSet.getDate("data_nascimento"));

                lista.add( new Contato(id, nome, email, endereco, data_nasc) );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Contato search(Long ID_requisitado) {
        String sql = "SELECT * FROM contatos where id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setString(1, ID_requisitado.toString());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id            = resultSet.getLong("id");
                String nome        = resultSet.getString("nome");
                String email       = resultSet.getString("email");
                String endereco    = resultSet.getString("endereco");
                Calendar data_nasc = Calendar.getInstance();
                data_nasc.setTime(resultSet.getDate("data_nascimento"));

                return new Contato(id, nome, email, endereco, data_nasc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(Contato contato) {
        String sql  = "UPDATE contatos SET "
                    + "nome = ?, "
                    + "email = ?, "
                    + "endereco = ?, "
                    + "data_nascimento = ? "
                    + "where id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setDate  (4, new Date(contato.getData_nascimento().getTimeInMillis()));
            statement.setLong  (5, contato.getID());
            statement.execute  ();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Contato contato) {
        String sql = "DELETE * FROM contatos WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql))
        {
            statement.setLong(1, contato.getID());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
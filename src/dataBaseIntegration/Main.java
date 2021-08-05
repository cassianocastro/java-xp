package dataBaseIntegration;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

/**
 * @author cassiano
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try( Connection connection = new ConnectionFactory().getConnection() ){
            ContatoDao dao = new ContatoDao( connection );
            insert(connection);
            read(dao);
            search(dao);
            
        }catch(SQLException e){
            System.exit(0);
        }
    }
    
    private static void read(ContatoDao dao){
        List<Contato> lista = dao.read();
        StringBuilder msg   = new StringBuilder();
        
        for (Contato contato : lista) {
            msg.append(contato.getDados());
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
    private static void search(ContatoDao dao){
        Long ID = Long.parseLong(JOptionPane.showInputDialog("ID:"));
        Contato contato = dao.search(ID);
        if ( contato != null )
            JOptionPane.showMessageDialog(null, contato.getDados());
        else
            JOptionPane.showMessageDialog(null, "Contato não encontrado!\nEncerrando Sistema...");
    }
    
    private static void insert(Connection connection){
        String nome     = JOptionPane.showInputDialog("Nome:");
        String email    = JOptionPane.showInputDialog("E-mail:");
        String endereco = JOptionPane.showInputDialog("Endereço:");
        
        Calendar data_nascimento = Calendar.getInstance();
        
        Contato contato = new Contato(null, nome, email, endereco, data_nascimento);
        
        new ContatoDao(connection).create(contato);
        
        JOptionPane.showMessageDialog(null, "Gravado!!");
    }
}
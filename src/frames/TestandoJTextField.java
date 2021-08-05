package frames;
import javax.swing.*;
/**
 *
 * @author cassiano
 */
public class TestandoJTextField extends JFrame{
    private static final long serialVersionUID = 1l;
    private JTextField txtExemplo;
    
    public TestandoJTextField(){
        this.setTitle("Exemplo");
        this.setSize(200, 180);
        
        this.txtExemplo = new JTextField(10);
        this.txtExemplo.setDocument(new TamanhoFixoJTextField(5));
        
        this.getContentPane().add(this.txtExemplo, "North");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
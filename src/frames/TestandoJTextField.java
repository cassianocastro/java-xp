package frames;

import javax.swing.*;

/**
 *
 */
public class TestandoJTextField extends JFrame
{

    private static final long serialVersionUID = 1l;
    private final JTextField txtExemplo;

    public TestandoJTextField()
    {
        super.setTitle("Exemplo");
        super.setSize(200, 180);

        this.txtExemplo = new JTextField(10);
        this.txtExemplo.setDocument(new TamanhoFixoJTextField(5));

        super.getContentPane().add(this.txtExemplo, "North");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 */
public class Test extends JFrame
{

    private final Painel painel;

    public Test()
    {
        super("Test");

        super.setSize(300, 100);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);

        this.painel = new Painel();

        super.setContentPane(this.painel);
        super.setVisible(true);
    }

    private class Painel extends JPanel implements ActionListener
    {

        private final JButton buttonOkay, buttonCancel;

        public Painel()
        {
            this.buttonOkay   = new JButton("Okay");
            this.buttonCancel = new JButton("Cancel");

            this.buttonOkay.addActionListener(this);
            this.buttonCancel.addActionListener(this);

            super.add(this.buttonOkay);
            super.add(this.buttonCancel);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(
                rootPane,
                ( e.getSource() == this.buttonOkay ) ? "Okay" : "Cancel"
            );
        }
    }
}
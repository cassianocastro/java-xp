package frames;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 */
public class TestandoIcones extends JFrame
{

    private final JPanel panel;
    private final PanelButtons panelButtons;

    public TestandoIcones()
    {
        super("Hora da Bóia");

        this.panel        = new JPanel(new GridLayout(2, 1));
        this.panelButtons = new PanelButtons();

        this.panel.add(new JLabel("Escolha uma das Opções:", JLabel.CENTER));
        this.panel.add(this.panelButtons);

        super.setSize(370, 120);
        super.setContentPane(this.panel);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private class PanelButtons extends JPanel implements ActionListener
    {

        private final JButton buttonCroissant, buttonIceCream, buttonPanettone;
        private final IconManager iconManager;

        public PanelButtons()
        {
            super.setLayout(new GridLayout(1, 3, 10, 10));

            this.iconManager     = new IconManager();
            this.buttonCroissant = new JButton("Croissant", this.iconManager.getIcon("croissant"));
            this.buttonIceCream  = new JButton("Sorvete", this.iconManager.getIcon("ice-cream"));
            this.buttonPanettone = new JButton("Panettone", this.iconManager.getIcon("panettone"));

            this.buttonCroissant.addActionListener(this);
            this.buttonIceCream.addActionListener(this);
            this.buttonPanettone.addActionListener(this);

            super.add(this.buttonCroissant);
            super.add(this.buttonIceCream);
            super.add(this.buttonPanettone);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();

            if ( source == this.buttonCroissant )
                JOptionPane.showMessageDialog(rootPane, "A opção foi " + this.buttonCroissant.getText());
            else if ( source == this.buttonIceCream )
                JOptionPane.showMessageDialog(rootPane, "A opção foi " + this.buttonIceCream.getText());
            else
                JOptionPane.showMessageDialog(rootPane, "A opção foi " + this.buttonPanettone.getText());
        }
    }
}

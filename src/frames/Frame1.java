package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 */
public class Frame1 extends JFrame
{

    private Pane1 pane1;
    private Pane2 pane2;
    private Pane3 pane3;
    private Pane4 pane4;
    private Pane5 pane5;

    public Frame1()
    {
        super("Swinger");

        // this.pane1 = new Pane1();
        // this.pane2 = new Pane2(new String[] {"Teste", "Rua 1", "Personal"});
        // this.pane3 = new Pane3();
        // this.pane4 = new Pane4();
        this.pane5 = new Pane5();

        super.setContentPane(this.pane5);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Nimbus"));
        } catch (UnsupportedLookAndFeelException e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        StringBuilder msg = new StringBuilder();
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        for ( UIManager.LookAndFeelInfo look : looks )
        {
            msg.append(look);
            msg.append("\n");
        }
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    private class Pane1 extends JPanel
    {

        protected Pane1()
        {
            super.setLayout(new BorderLayout());
            super.add(new JLabel("Hello"), BorderLayout.NORTH);
            super.add(new JButton("Yes"), BorderLayout.SOUTH);
        }
    }

    private class Pane2 extends JPanel
    {

        private final JTextField[] fields;

        protected Pane2(String[] args)
        {
            super.setLayout(new GridLayout(3, 1));

            this.fields = new JTextField[3];

            for ( byte i = 0; i < this.fields.length; i++ )
            {
                this.fields[i] = new JTextField(args[i], 20);
            }

            super.add(new JLabel("Título:"));
            super.add(this.fields[0]);
            super.add(new JLabel("Endereço:"));
            super.add(this.fields[1]);
            super.add(new JLabel("Tipo:"));
            super.add(this.fields[2]);
        }
    }

    private class Pane3 extends JPanel implements ActionListener
    {

        private final JButton button1, button2;

        protected Pane3()
        {
            this.button1 = new JButton("Cassiano");
            this.button2 = new JButton("Marilene");

            this.button1.addActionListener(this);
            this.button2.addActionListener(this);

            super.add(this.button1);
            super.add(this.button2);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();

            if ( source == this.button1 )
                setTitle("Cassiano");
            else if ( source == this.button2 )
                setTitle("Marilene");

            repaint();
        }
    }

    private class Pane4 extends JPanel implements AdjustmentListener
    {

        private final JTextField textfield;
        private final JScrollBar scrollBar;

        protected Pane4()
        {
            super.setLayout(new BorderLayout());
            this.textfield = new JTextField();
            this.scrollBar = new JScrollBar(SwingConstants.HORIZONTAL, 52, 10, 0, 100);

            this.scrollBar.addAdjustmentListener(this);
            this.scrollBar.setMaximum(110);

            this.textfield.setHorizontalAlignment(JTextField.CENTER);
            this.textfield.setEditable(false);

            super.add(this.textfield, BorderLayout.SOUTH);
            super.add(this.scrollBar, BorderLayout.NORTH);
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
            Object source = e.getSource();

            if ( source == this.scrollBar )
            {
                String novoValor = String.valueOf(this.scrollBar.getValue());
                this.textfield.setText(novoValor);
            }
            repaint();
        }
    }

    private class Pane5 extends JPanel implements ItemListener, ActionListener
    {

        private final JTextField textField;
        private final JComboBox<String> comboBox;
        private final JButton button;

        protected Pane5()
        {
            super.setLayout(new BorderLayout());

            this.button    = new JButton("Submit");
            this.textField = new JTextField("Nenhum item selecionado", 27);
            this.comboBox  = new JComboBox(
                new String[]
                {
                    "Navigator",
                    "Opera GX",
                    "Internet Explorer",
                    "Google Chrome",
                    "Mozilla Firefox"
                }
            );
            this.comboBox.addItemListener(this);
            this.button.addActionListener(this);
            this.comboBox.setEditable(false);

            this.textField.setHorizontalAlignment(SwingConstants.CENTER);
            this.textField.setEditable(false);

            super.add(this.textField, "North");
            super.add(this.comboBox, "Center");
            super.add(this.button, "South");
        }

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            Object source = e.getSource();

            if ( source == this.comboBox )
            {
                Object novo_pick = e.getItem();
                this.textField.setText(novo_pick.toString() + " foi selecionado.");
            }
            repaint();
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();
            
            if ( source == this.button )
            {
                String item = this.comboBox.getSelectedItem().toString();
                this.textField.setText(item + " foi selecionado.");
            }
            repaint();
        }
    }
}

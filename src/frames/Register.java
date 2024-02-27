package frames;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 */
public class Register extends JFrame
{

    private final GridLayout layout;

    public Register()
    {
        super("Novo Cadastro");

        this.layout = new GridLayout(4, 1);
        RootPanel p = new RootPanel(this.layout);

        super.setContentPane(p);
        super.pack();
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private class RootPanel extends JPanel
    {

        private final PanelLabels panelLabels;
        private final PanelFields panelFields;
        private final PanelButtons panelButtons;
        private final JComponent rootPanel;
        private final JLabel label;

        public RootPanel(LayoutManager layout)
        {
            super.setLayout(new BorderLayout());

            this.label = new JLabel(
                "Insira os dados:",
                new ImageIcon("/home/cassiano/Imagens/project.png"),
                SwingConstants.CENTER
            );

            this.panelLabels  = new PanelLabels(layout);
            this.panelFields  = new PanelFields(layout);
            this.panelButtons = new PanelButtons();
            this.rootPanel    = new JPanel(new BorderLayout(10, 0));

            this.rootPanel.add(this.panelLabels, "West");
            this.rootPanel.add(this.panelFields, "Center");
            this.rootPanel.add(this.panelButtons, "South");

            super.add(this.label, "North");
            super.add(this.rootPanel, "Center");
        }
    }

    private class PanelLabels extends JPanel
    {

        private final String[] labels;

        public PanelLabels(LayoutManager layout)
        {
            super.setLayout(layout);

            this.labels = new String[]
            {
                "Nome:", "Nascimento:", "CPF:", "Sexo:"
            };

            for ( String label : this.labels )
            {
                super.add(new JLabel(label, SwingConstants.RIGHT));
            }
        }
    }

    public class PanelFields extends JPanel
    {

        private JFormattedTextField[] fields;
        private JComboBox combo;

        public PanelFields(LayoutManager layout)
        {
            super.setLayout(layout);

            this.fields = new JFormattedTextField[3];
            this.combo  = new JComboBox();

            try
            {
                this.fields[0] = new JFormattedTextField(new MaskFormatter());
                this.fields[1] = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
                this.fields[2] = new JFormattedTextField(new MaskFormatter("##/##/####"));
            } catch (ParseException e)
            {
                throw new RuntimeException(e);
            }

            for ( JFormattedTextField field : this.fields )
            {
                field.setColumns(20);
                super.add(field);
            }
            super.add(this.combo);
        }
    }

    private class PanelButtons extends JPanel implements ActionListener
    {

        private final JButton buttonSave, buttonCancel;

        public PanelButtons()
        {
            this.buttonSave   = new JButton("Save");
            this.buttonCancel = new JButton("Cancel");

            this.buttonSave.addActionListener(this);
            this.buttonCancel.addActionListener(this);

            super.add(this.buttonSave);
            super.add(this.buttonCancel);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*
                Object o = e.getSource();

                if ( o == this.buttonSalvar )
                {
                    this.dados = new String[]
                    {
                        this.fieldNome      .getText(),
                        this.fieldCPF       .getText(),
                        this.comboSexo      .getSelectedItem().toString(),
                        this.fieldNascimento.getText()
                    };
                } else if ( o == this.buttonCancelar )
                    JOptionPane.showMessageDialog(rootPane, "Op. cancelada.");
                this.dispose();
            */
        }
    }
}
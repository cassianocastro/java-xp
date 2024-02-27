package frames;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.*;

/**
 *
 */
public class PercentagemScreen extends JFrame
{

    private final PanelInput Pinput;
    private final PanelRadios Pradio;
    private final PanelResult Presult;
    private final Color color;

    public PercentagemScreen()
    {
        super("Tratando eventos em botão de rádio");

        this.color   = new Color(200, 200, 200);
        this.Pinput  = new PanelInput(color);
        this.Presult = new PanelResult();
        this.Pradio  = new PanelRadios(color, Pinput, Presult);

        super.add(Pinput);
        super.add(Pradio);
        super.add(Presult);

        super.setSize(400, 120);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new GridLayout(3, 1));
        super.setVisible(true);
    }

    private class PanelInput extends JPanel
    {

        private final JLabel label;
        private final JTextField textField;

        public PanelInput(Color color)
        {
            this.label     = new JLabel("Valor:");
            this.textField = new JTextField(5);

            this.label.setForeground(Color.BLUE);

            super.setLayout(new FlowLayout(FlowLayout.CENTER));
            super.add(this.label);
            super.add(this.textField);
            super.setBackground(color);
        }

        public String getString()
        {
            return this.textField.getText();
        }
    }

    private class PanelRadios extends JPanel implements ItemListener
    {

        private final JRadioButton[] radios;
        private final ButtonGroup group;
        private final PanelInput pi;
        private final String[] labelsRadio;
        private final int[] keys;
        private final PanelResult p;

        public PanelRadios(Color color, PanelInput pi, PanelResult p)
        {
            super.setLayout(new GridLayout(2, 3));
            super.setBackground(color);

            this.p  = p;
            this.pi = pi;
            this.group       = new ButtonGroup();
            this.radios      = new JRadioButton[3];
            this.labelsRadio = new String[]
            {
                "10%", "20%", "30%"
            };
            this.keys = new int[]
            {
                KeyEvent.VK_1,
                KeyEvent.VK_2,
                KeyEvent.VK_3
            };

            for ( byte i = 0; i < this.radios.length; i++ )
            {
                this.radios[i] = new JRadioButton(this.labelsRadio[i]);
                this.radios[i].setMnemonic(this.keys[i]);
                this.radios[i].addItemListener(this);
                this.group.add(this.radios[i]);
                super.add(this.radios[i]);
            }
            this.radios[0].setSelected(true);
        }

        @Override
        public void itemStateChanged(ItemEvent event)
        {
            String text = this.pi.getString();

            if ( text.isEmpty() )
            {
                return;
            }

            try
            {
                BigDecimal N1 = new BigDecimal(text);
                BigDecimal result;

                if ( this.radios[0].isSelected() )
                {
                    result = N1.multiply(new BigDecimal("0.1"));
                } else if ( this.radios[1].isSelected() )
                {
                    result = N1.multiply(new BigDecimal("0.2"));
                } else
                {
                    result = N1.multiply(new BigDecimal("0.3"));
                }

                this.p.setResult(result.toString());
            } catch (NumberFormatException e)
            {
                this.p.setResult("Error");
            }
        }
    }

    private class PanelResult extends JPanel
    {

        private final JLabel label;
        private final JTextField textField;

        protected PanelResult()
        {
            this.label     = new JLabel("Resultado:");
            this.textField = new JTextField(5);

            this.label.setForeground(Color.BLUE);
            this.textField.setEditable(false);

            super.add(this.label);
            super.add(this.textField);
        }

        public void setResult(String text)
        {
            this.textField.setText(text);
        }
    }
}
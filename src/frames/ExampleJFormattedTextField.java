package frames;

import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 */
public class ExampleJFormattedTextField extends JFrame
{

    public ExampleJFormattedTextField()
    {
        super.setContentPane( new Pane() );
        super.setBounds( 400, 200, 400, 250 );
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private class Pane extends JPanel
    {

        private final JLabel labelCEP, labelTEL, labelCPF, labelDATA;
        private JFormattedTextField CEP, CPF, TEL, DATA;

        protected Pane()
        {
            super.setLayout(null);
            try
            {
                this.CEP  = new JFormattedTextField( new MaskFormatter("#####-###") );
                this.TEL  = new JFormattedTextField( new MaskFormatter("(##)#####-####") );
                this.CPF  = new JFormattedTextField( new MaskFormatter("###.###.###-##") );
                this.DATA = new JFormattedTextField( new MaskFormatter("##/##/####") );
            } catch( ParseException e )
            {
                System.err.println( e.getMessage() );
                System.exit(0);
            }
            
            this.labelCEP  = new JLabel("CEP:");
            this.labelTEL  = new JLabel("Telefone:");
            this.labelCPF  = new JLabel("CPF:");
            this.labelDATA = new JLabel("Data:");

            this.labelCEP .setBounds(85, 40, 100, 20);
            this.labelTEL .setBounds(50, 70, 100, 20);
            this.labelCPF .setBounds(85, 100, 100, 20);
            this.labelDATA.setBounds(77, 130, 100, 20);

            this.CEP .setBounds (130, 40, 120, 20);
            this.TEL .setBounds (130, 70, 120, 20);
            this.CPF .setBounds (130, 100, 120, 20);
            this.DATA.setBounds (130, 130, 120, 20);

            super.add(this.labelCEP);
            super.add(this.labelTEL);
            super.add(this.labelCPF);
            super.add(this.labelDATA);

            super.add(this.CEP);
            super.add(this.TEL);
            super.add(this.CPF);
            super.add(this.DATA);
        }
    }
}
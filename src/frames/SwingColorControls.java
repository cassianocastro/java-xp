package frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 */
public class SwingColorControls extends JPanel implements ActionListener, FocusListener
{

    private final SwingColorTest frame;
    public JTextField[] textFields;

    public SwingColorControls(SwingColorTest parent, String a, String b, String c)
    {
        super.setLayout(new GridLayout(3, 2, 10, 10));

        this.frame = parent;
        this.textFields = new JTextField[3];

        for ( JTextField textField : this.textFields )
        {
            textField = new JTextField("0");
            textField.addFocusListener(this);
            textField.addActionListener(this);
        }
        super.add(new JLabel(a, JLabel.RIGHT));
        super.add(this.textFields[0]);

        super.add(new JLabel(b, JLabel.RIGHT));
        super.add(this.textFields[1]);

        super.add(new JLabel(c, JLabel.RIGHT));
        super.add(this.textFields[2]);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() instanceof TextField )
        {
            this.frame.update(this);
        }
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        this.frame.update(this);
    }

    @Override
    public void focusLost(FocusEvent e)
    {
    }
}

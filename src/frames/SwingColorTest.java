package frames;

import java.awt.*;
import javax.swing.*;

/**
 *
 */
public class SwingColorTest extends JFrame
{

    private final SwingColorControls RGBcontrols, HSBcontrols;
    private final JComponent panel, panel2;

    public SwingColorTest()
    {
        super("Color Test");

        this.panel  = new JPanel(new GridLayout(1, 3, 5, 15));
        this.panel2 = new JPanel();
        this.RGBcontrols = new SwingColorControls(this, "Red", "Green", "Blue");
        this.HSBcontrols = new SwingColorControls(this, "Hue", "Saturation", "Brightness");

        this.panel2.setBackground(Color.BLACK);

        this.panel.add(this.panel2);
        this.panel.add(this.RGBcontrols);
        this.panel.add(this.HSBcontrols);

        super.setContentPane(this.panel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public void update(SwingColorControls ControlPanel)
    {
        Color c;

        int valor1 = Integer.parseInt(ControlPanel.textFields[0].getText());
        int valor2 = Integer.parseInt(ControlPanel.textFields[1].getText());
        int valor3 = Integer.parseInt(ControlPanel.textFields[2].getText());

        if ( ControlPanel == this.RGBcontrols )
        {
            c = new Color(valor1, valor2, valor3);

            float[] HSB = Color.RGBtoHSB(valor1, valor2, valor3, ( new float[3] ));
            HSB[0] *= 360;
            HSB[1] *= 100;
            HSB[2] *= 100;

            this.HSBcontrols.textFields[0].setText(String.valueOf((int) HSB[0]));
            this.HSBcontrols.textFields[1].setText(String.valueOf((int) HSB[1]));
            this.HSBcontrols.textFields[2].setText(String.valueOf((int) HSB[2]));
        } else
        {
            c = Color.getHSBColor(
                (float) valor1 / 360,
                (float) valor2 / 100,
                (float) valor3 / 100
            );
            this.RGBcontrols.textFields[0].setText(String.valueOf(c.getRed()));
            this.RGBcontrols.textFields[1].setText(String.valueOf(c.getGreen()));
            this.RGBcontrols.textFields[2].setText(String.valueOf(c.getBlue()));
        }
        this.panel2.setBackground(c);
        this.panel2.repaint();
    }
}

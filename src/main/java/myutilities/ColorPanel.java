package myutilities;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ColorPanel extends JPanel
{
    public ColorPanel(Color clr)
    {
        this.setBackground(clr);
    }

    public ColorPanel(Color clr, int x, int y)
    {
        this.setBackground(clr);
        this.setPreferredSize(new Dimension(x, y));
    }
}

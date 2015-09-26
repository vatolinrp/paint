//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import myutilities.ColorPanel;
import painttools.ToolEnum;

public class ColorPicker extends JPanel
{
    protected ColorOptionBox[] colorOptions;
    protected ArrayList points;
    protected Color[] colors;
    protected Color color;

    public ColorPicker()
    {
        this.setBackground(Color.darkGray);
        this.setPreferredSize(new Dimension(92, 92));
        this.setLayout(new BorderLayout());
        this.colors = new Color[32];
        int count = 0;

        int holder;
        for (int colorGrid = 1; colorGrid < 5; ++colorGrid)
        {
            for (holder = 1; holder < 5; ++holder)
            {
                for (int holder2 = 1; holder2 < 3; ++holder2)
                {
                    this.colors[count] = new Color(colorGrid * 51, holder * 51, holder2 * 127);
                    ++count;
                }
            }
        }

        this.color = Color.black;
        JPanel fillColors = new JPanel();
        fillColors.setBackground(Color.darkGray);
        fillColors.setLayout(new GridLayout(4, 10, 6, 6));
        this.colorOptions = new ColorOptionBox[this.colors.length];

        for (holder = 0; holder < this.colorOptions.length; ++holder)
        {
            this.colorOptions[holder] = new ColorOptionBox(this.colors[holder]);
            fillColors.add(this.colorOptions[holder]);
        }


        JPanel lineColors = new JPanel();
        lineColors.setBackground(Color.darkGray);
        lineColors.setLayout(new GridLayout(4, 10, 6, 6));
        this.colorOptions = new ColorOptionBox[this.colors.length];

        for (holder = 0; holder < this.colorOptions.length; ++holder)
        {
            this.colorOptions[holder] = new ColorOptionBox(this.colors[holder]);
            lineColors.add(this.colorOptions[holder]);
        }

        JPanel leftColorWrapper = new JPanel();
        leftColorWrapper.setLayout(new BorderLayout());
        leftColorWrapper.add(new ColorPanel(Color.darkGray), "West");
        leftColorWrapper.add(new ColorPanel(Color.darkGray), "East");
        leftColorWrapper.add(new ColorPanel(Color.darkGray), "South");
        leftColorWrapper.add(new ColorPanel(Color.darkGray), "North");
        leftColorWrapper.add(fillColors, "Center");
        this.add(leftColorWrapper, "Center");
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}

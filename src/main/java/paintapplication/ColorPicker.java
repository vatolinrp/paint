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
    protected JPanel currentClrPanel;
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
        this.currentClrPanel = new JPanel();
        this.currentClrPanel.setBackground(Color.white);
        this.currentClrPanel.setPreferredSize(new Dimension(92, 92));
        this.currentClrPanel.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent event)
            {
                if (Main.paint.drawPanel.getTool() != ToolEnum.ERASER)
                {
                    ColorPicker.this.currentClrPanel.setBackground(JColorChooser.showDialog(Main.paint, "Change Color",
                            Main.paint.drawPanel.brushColor));
                    ColorPicker.this.color = ColorPicker.this.currentClrPanel.getBackground();
                    Main.paint.drawPanel.tool.setColor(ColorPicker.this.currentClrPanel.getBackground());
                    Main.paint.drawPanel.setBrushColor(ColorPicker.this.color);
                }

            }
        });
        JPanel var5 = new JPanel();
        var5.setBackground(Color.darkGray);
        var5.setLayout(new GridLayout(2, 16, 6, 6));
        this.colorOptions = new ColorOptionBox[this.colors.length];

        for (holder = 0; holder < this.colorOptions.length; ++holder)
        {
            this.colorOptions[holder] = new ColorOptionBox(this.colors[holder]);
            var5.add(this.colorOptions[holder]);
        }

        ColorPanel var6 = new ColorPanel(Color.darkGray);
        var6.setLayout(new BorderLayout(6, 6));
        var6.add(this.currentClrPanel, "West");
        var6.add(var5, "Center");
        JPanel var7 = new JPanel();
        var7.setLayout(new BorderLayout());
        var7.add(new ColorPanel(Color.darkGray), "West");
        var7.add(new ColorPanel(Color.darkGray), "East");
        var7.add(new ColorPanel(Color.darkGray), "South");
        var7.add(new ColorPanel(Color.darkGray), "North");
        var7.add(var6, "Center");
        this.add(var7, "Center");
    }

    public void deselectAll()
    {
        for (int i = 0; i < this.colorOptions.length; ++i)
        {
            this.colorOptions[i].selected = false;
        }

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}

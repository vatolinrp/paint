package paintapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PaintApplication extends JFrame
{
    public DrawPanel drawPanel;
    protected PaintMenuBar menuBar;
    protected ColorPicker colorPicker;

    public PaintApplication()
    {
        this.setSize(1024, 768);
        this.setLayout(new BorderLayout());
        this.drawPanel = new DrawPanel();
        this.menuBar = new PaintMenuBar();
        this.colorPicker = new ColorPicker();
        this.add(this.menuBar, "North");
        this.add(this.colorPicker, "South");
        this.add(new JScrollPane(this.drawPanel), "Center");
        this.setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

package paintapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import paintcontrols.PaintToolPanel;

import paintcontrols.RectShapeToolPanel;
import painttools.ToolEnum;

public class PaintApplication extends JFrame
{
    public DrawPanel drawPanel;
    protected PaintMenuBar menuBar;
    protected ColorPicker colorPicker;
    public PaintToolPanel paintTools;

    public PaintApplication()
    {
        this.setSize(1024, 768);
        this.setLayout(new BorderLayout());
        this.drawPanel = new DrawPanel();
        this.menuBar = new PaintMenuBar();
        this.colorPicker = new ColorPicker();
        this.paintTools = new PaintToolPanel(new RectShapeToolPanel(ToolEnum.LINE));
        this.add(this.menuBar, "North");
        this.add(this.colorPicker, "South");
        this.add(this.paintTools, "West");
        this.add(new JScrollPane(this.drawPanel), "Center");
        this.setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.synchronizeStartingColor();
    }

    public void synchronizeStartingColor()
    {
        this.colorPicker.currentClrPanel.setBackground(Color.black);
        this.colorPicker.color = this.colorPicker.currentClrPanel.getBackground();
        this.drawPanel.tool.setColor(this.colorPicker.currentClrPanel.getBackground());
        this.drawPanel.setBrushColor(this.colorPicker.color);
    }
}

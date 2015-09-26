package paintcontrols;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import painttools.ToolEnum;

public class ConfigPanel extends JPanel
{
    protected ToolButton[] buttons;
    public ToolOptionPanel toolOptionPanel;

    public ConfigPanel(ToolOptionPanel toolOptionPanel)
    {
        this.setBackground(Color.darkGray);
        this.setPreferredSize(new Dimension(192, 0));
        this.setLayout(new BorderLayout(1, 2));
        this.toolOptionPanel = toolOptionPanel;
        this.add(toolOptionPanel, "South");
    }

    public void setToolOptionPanel(ToolOptionPanel panel)
    {
        this.remove(this.toolOptionPanel);
        this.toolOptionPanel = panel;
        this.add(this.toolOptionPanel, "South");
        this.revalidate();
        this.repaint();
    }
}

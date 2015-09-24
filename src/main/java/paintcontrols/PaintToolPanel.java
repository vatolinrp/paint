//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import painttools.Tool;

public class PaintToolPanel extends JPanel {
    protected ToolButton[] buttons;
    public ToolOptionPanel toolOptionPanel;

    public PaintToolPanel(ToolOptionPanel toolOptionPanel) {
        this.setBackground(Color.darkGray);
        this.setPreferredSize(new Dimension(192, 0));
        this.setLayout(new BorderLayout(8, 8));
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(5, 2));
        toolPanel.setBackground(Color.darkGray);
        toolPanel.setPreferredSize(new Dimension(292, 350));
        this.toolOptionPanel = toolOptionPanel;
        this.buttons = new ToolButton[10];
        ImageIcon[] icons = new ImageIcon[10];
        String[] var10000 = new String[]{"pencil.png", "eraser.png"};

        for(int pencil = 0; pencil < icons.length; ++pencil) {
            ;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        ImageIcon var16 = new ImageIcon(classLoader.getResource("pencil.png"));
        ImageIcon eraser = new ImageIcon(classLoader.getResource("eraser.png"));
        ImageIcon rectangle = new ImageIcon(classLoader.getResource("rectangle.png"));
        ImageIcon oval = new ImageIcon(classLoader.getResource("oval.png"));
        ImageIcon colorPicker = new ImageIcon(classLoader.getResource("color-picker.png"));
        ImageIcon paintBucket = new ImageIcon(classLoader.getResource("paint-bucket.png"));
        ImageIcon airBrush = new ImageIcon(classLoader.getResource("air-brush.png"));
        ImageIcon polygon = new ImageIcon(classLoader.getResource("polygon.png"));
        ImageIcon lineTool = new ImageIcon(classLoader.getResource("line-tool.png"));
        ImageIcon paintBrush = new ImageIcon(classLoader.getResource("paint-brush.png"));
        this.buttons[0] = new ToolButton(var16, Tool.PENCIL);
        this.buttons[1] = new ToolButton(paintBrush, Tool.BRUSH);
        this.buttons[2] = new ToolButton(eraser, Tool.ERASER);
        this.buttons[3] = new ToolButton(paintBucket, Tool.FILLER);
        this.buttons[4] = new ToolButton(colorPicker, Tool.PICKER);
        this.buttons[5] = new ToolButton(airBrush, Tool.AIRBRUSH);
        this.buttons[6] = new ToolButton(rectangle, Tool.RECTANGLE);
        this.buttons[7] = new ToolButton(oval, Tool.OVAL);
        this.buttons[9] = new ToolButton(lineTool, Tool.LINE);
        this.buttons[8] = new ToolButton(polygon, Tool.ROUND_RECT);

        for(int i = 0; i < this.buttons.length; ++i) {
            toolPanel.add(this.buttons[i]);
        }

        this.add(toolPanel, "North");
        this.add(toolOptionPanel, "South");
    }

    public void setToolOptionPanel(ToolOptionPanel panel) {
        this.remove(this.toolOptionPanel);
        this.toolOptionPanel = panel;
        this.add(this.toolOptionPanel, "South");
        this.revalidate();
        this.repaint();
    }
}

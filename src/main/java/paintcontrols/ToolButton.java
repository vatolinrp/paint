//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import paintapplication.Main;
import painttools.Tool;

public class ToolButton extends JButton implements ActionListener {
    boolean hover;
    boolean selected;
    JLabel label;
    Tool tool;

    public ToolButton(String text, Tool tool) {
        this.label = new JLabel(text);
        this.add(this.label);
        this.tool = tool;
        this.addActionListener(this);
    }

    public ToolButton(Icon icon, Tool tool) {
        this.label = new JLabel(icon);
        this.setLayout(new BorderLayout());
        this.add(this.label);
        this.tool = tool;
        this.addActionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actionPerformed(ActionEvent event) {
        Main.paint.drawPanel.setTool(this.tool);
        System.out.println("Your Tool has been changed to " + this.tool);
        Main.paint.repaint();
    }
}

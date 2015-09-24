//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import painttools.Tool;

public abstract class ToolOptionPanel extends JPanel {
    Tool tool;
    Color color;

    public ToolOptionPanel(Tool tool) {
        this.tool = tool;
        this.setPreferredSize(new Dimension(164, 256));
        this.setBackground(Color.darkGray);
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public Color getColor() {
        return this.color;
    }
}

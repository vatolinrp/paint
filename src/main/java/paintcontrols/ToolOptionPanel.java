//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.*;
import javax.swing.JPanel;
import painttools.ToolEnum;

public abstract class ToolOptionPanel extends JPanel {
    ToolEnum tool;
    Color color;

    public ToolOptionPanel(ToolEnum tool) {
        this.tool = tool;
        this.setPreferredSize(new Dimension(164, 256));
        this.setBackground(Color.darkGray);
        this.setLayout(new FlowLayout());
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public Color getColor() {
        return this.color;
    }
}

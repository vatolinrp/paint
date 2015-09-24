//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import myutilities.ColorPanel;
import painttools.ToolEnum;

public class ColorPickerToolPanel extends ToolOptionPanel {
    protected Color color;
    protected JPanel showColor;

    public ColorPickerToolPanel(ToolEnum tool, Color clr) {
        super(tool);
        this.showColor = new ColorPanel(this.color);
        this.showColor.setPreferredSize(new Dimension(150, 120));
        this.add(this.showColor, "North");
    }

    public void setColor(Color clr) {
        this.showColor.setBackground(clr);
        this.color = clr;
    }

    public Color getColor() {
        return this.color;
    }
}

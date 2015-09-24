//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Dimension;
import java.awt.GridLayout;

import painttools.StrokeStyleEnum;
import painttools.ToolEnum;
import paintvisuals.ToolOptionIcon;

public class DragShapeToolPanel extends BrushToolPanel {
    public DragShapeToolPanel(ToolEnum tool, int stroke) {
        super(tool, stroke);
        this.buttonHolder.remove(this.strokeStyles[0]);
        this.buttonHolder.setLayout(new GridLayout(2, 1));
        this.buttonHolder.setPreferredSize(new Dimension(100, 92));
        this.buttonHolder.remove(this.strokeStyles[1]);
        this.buttonHolder.remove(this.strokeStyles[2]);
        this.strokeStyles[1].remove(this.styleIcons[1]);
        this.styleIcons[1] = new ToolOptionIcon(StrokeStyleEnum.LINE_DASHED);
        this.strokeStyles[1].add(this.styleIcons[1]);
        this.buttonHolder.add(this.strokeStyles[2]);
        this.buttonHolder.add(this.strokeStyles[1]);
    }
}

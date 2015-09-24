//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintdrawtools;

import java.awt.Color;
import java.awt.Graphics;
import paintdrawtools.BrushElement;
import paintdrawtools.PencilTool;
import painttools.StrokeStyle;

public class BrushTool extends PencilTool {
    public BrushTool(Color clr, int dim, StrokeStyle style) {
        super(clr, dim);
        this.strokeStyle = style;
        this.element = new BrushElement();
    }

    public void drawElement(Graphics g) {
        this.element.update(g);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintdrawtools;

import java.awt.Color;
import java.awt.Graphics;
import paintdrawtools.PencilElement;
import painttools.PaintTool;

public class PencilTool extends PaintTool {
    public PencilTool(Color clr, int dim) {
        super(clr, dim);
        this.element = new PencilElement();
        this.strokeWidth = dim;
        this.isDrawing = false;
    }

    public void drawElement(Graphics g) {
        this.element.update(g);
    }
}

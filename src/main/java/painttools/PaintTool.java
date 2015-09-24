//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package painttools;

import java.awt.Color;
import java.awt.Graphics;
import paintdrawtools.PaintElement;
import painttools.AbstractTool;

public abstract class PaintTool extends AbstractTool {
    protected PaintElement element;

    public PaintTool(Color clr, int dim) {
        super(clr, dim);
        this.isDrawing = false;
    }

    public PaintElement getElement() {
        return this.element;
    }

    public abstract void drawElement(Graphics var1);
}

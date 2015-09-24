//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import paintdrawtools.PaintElement;
import painttools.StrokeStyleEnum;

public abstract class DragElement extends PaintElement {
    protected Point sPoint;
    protected Point fPoint;

    public DragElement(Color clr, Point pt1, Point pt2, int dim, StrokeStyleEnum style) {
        super(clr, dim, style);
        this.sPoint = pt1;
        this.fPoint = pt2;
    }

    public Point getSPoint() {
        return this.sPoint;
    }

    public Point getFPoint() {
        return this.fPoint;
    }

    public abstract void update(Graphics var1);
}

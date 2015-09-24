//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;
import java.awt.Point;
import paintshapetools.DragElement;
import painttools.AbstractTool;

public abstract class DragTool extends AbstractTool {
    Point sPoint;
    Point fPoint;
    boolean finished = false;
    DragElement element;

    public DragTool(Color clr, int dim) {
        super(clr, dim);
    }

    public Point getSPoint() {
        return this.sPoint;
    }

    public void setSPoint(Point pt) {
        this.sPoint = pt;
    }

    public Point getFPoint() {
        return this.fPoint;
    }

    public void setFPoint(Point pt) {
        this.fPoint = pt;
    }

    public DragElement getElement() {
        return this.element;
    }

    public void setElement(DragElement element) {
        this.element = element;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }
}

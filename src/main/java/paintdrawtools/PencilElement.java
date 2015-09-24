//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintdrawtools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import paintdrawtools.PaintElement;
import painttools.StrokeStyle;

public class PencilElement extends PaintElement {
    Point previousPt;

    public PencilElement(Point pt, Color clr, int dim, StrokeStyle style) {
        super(pt, clr, dim, style);
        this.setStrokeWidth(dim);
    }

    public PencilElement(Point pt1, Point pt2, Color clr, int dim) {
        super(pt1, clr, dim);
        this.setStrokeWidth(dim);
        this.previousPt = pt2;
    }

    public PencilElement(Point pt1, Color clr, int dim) {
        super(pt1, clr, dim);
        this.setStrokeWidth(dim);
    }

    public PencilElement() {
    }

    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(this.color);
        g2d.setStroke(new BasicStroke((float)this.strokeWidth, 1, 1));
        g2d.drawLine(this.coors.x, this.coors.y, this.previousPt.x, this.previousPt.y);
        g2d.setStroke(new BasicStroke(1.0F));
    }
}

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

import painttools.StrokeStyleEnum;

public class BrushElement extends PencilElement {
    public BrushElement(Point pt, Color clr, int dim, StrokeStyleEnum style) {
        super(pt, clr, dim, style);
        this.setStrokeWidth(dim);
    }

    public BrushElement(Point pt1, Point pt2, Color clr, int dim, StrokeStyleEnum style) {
        super(pt1, clr, dim, style);
        this.setStrokeWidth(dim);
        this.previousPt = pt2;
    }

    public BrushElement() {
    }

    public void update(Graphics g) {
        int var10003;
        if(this.strokeStyle == StrokeStyleEnum.DOT_CIRC) {
            g.setColor(this.getColor());
            var10003 = this.strokeWidth + 1;
            g.fillOval(this.getCoors().x, this.getCoors().y, var10003, this.strokeWidth + 1);
            g.drawOval(this.getCoors().x, this.getCoors().y, this.strokeWidth, this.strokeWidth);
        }

        if(this.strokeStyle == StrokeStyleEnum.DOT_RECT) {
            g.setColor(this.getColor());
            var10003 = this.strokeWidth + 1;
            g.fillRect(this.getCoors().x, this.getCoors().y, var10003, this.strokeWidth + 1);
            g.drawRect(this.getCoors().x, this.getCoors().y, this.strokeWidth, this.strokeWidth);
        }

        if(this.strokeStyle == StrokeStyleEnum.LINE) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(this.color);
            g2d.setStroke(new BasicStroke((float)this.strokeWidth, 1, 1));
            g2d.drawLine(this.coors.x, this.coors.y, this.previousPt.x, this.previousPt.y);
            g2d.setStroke(new BasicStroke(1.0F));
        }

    }
}

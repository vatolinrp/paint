//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import paintshapetools.DragElement;
import painttools.StrokeStyle;

public class OvalElement extends DragElement {
    public OvalElement(Color clr, Point pt1, Point pt2, int dim, StrokeStyle style) {
        super(clr, pt1, pt2, dim, style);
    }

    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(this.color);
        g2d.setStroke(new BasicStroke((float)this.strokeWidth, 1, 1));
        if(this.strokeStyle == StrokeStyle.OPEN_OVAL) {
            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.drawOval(this.fPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.drawOval(this.sPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.drawOval(this.sPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }

            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.drawOval(this.fPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }
        }

        if(this.strokeStyle == StrokeStyle.FILL_OVAL) {
            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.fillOval(this.fPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.fillOval(this.sPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.fillOval(this.sPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }

            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.fillOval(this.fPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            }
        }

    }
}
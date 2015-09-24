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
import paintshapetools.RectangleElement;
import painttools.StrokeStyle;

public class RoundRectElement extends RectangleElement {
    public RoundRectElement(Color clr, Point pt1, Point pt2, int dim, StrokeStyle style) {
        super(clr, pt1, pt2, dim, style);
    }

    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(this.color);
        g2d.setStroke(new BasicStroke((float)this.strokeWidth, 1, 0));
        int[] arcs = new int[]{32, 32};
        if(this.strokeStyle == StrokeStyle.OPEN_ROUND_RECT) {
            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.drawRoundRect(this.fPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.drawRoundRect(this.sPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.drawRoundRect(this.sPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }

            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.drawRoundRect(this.fPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }
        }

        if(this.strokeStyle == StrokeStyle.FILL_ROUND_RECT) {
            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.fillRoundRect(this.fPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y < 0) {
                g2d.fillRoundRect(this.sPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }

            if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.fillRoundRect(this.sPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }

            if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y > 0) {
                g2d.fillRoundRect(this.fPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y), arcs[0], arcs[1]);
            }
        }

    }
}

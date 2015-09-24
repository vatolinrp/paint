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

public class LineElement extends DragElement {
    public LineElement(Color clr, Point pt1, Point pt2, int dim, StrokeStyle style) {
        super(clr, pt1, pt2, dim, style);
        this.strokeStyle = style;
    }

    public void update(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(this.color);
        g2d.setStroke(new BasicStroke((float)this.strokeWidth, 1, 1));
        switch(this.strokeStyle.ordinal()) {
            case 1:
                g.drawLine(this.sPoint.x, this.sPoint.y, this.fPoint.x, this.fPoint.y);
                break;
            case 2:
                float[] dashes = new float[]{24.0F};
                g2d.setStroke(new BasicStroke((float)this.strokeWidth, 1, 1, 32.0F, dashes, 0.0F));
                g.drawLine(this.sPoint.x, this.sPoint.y, this.fPoint.x, this.fPoint.y);
        }

    }
}

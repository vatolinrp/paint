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

import painttools.StrokeStyleEnum;

public class LineElement extends DragElement
{
    public LineElement(Color clr, Point pt1, Point pt2, StrokeStyleEnum style)
    {
        super(clr, pt1, pt2, style);
        this.strokeStyle = style;
    }

    public void update(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.color);
        g2d.setStroke(new BasicStroke((float) 5, 1, 1));
        g.drawLine(this.sPoint.x, this.sPoint.y, this.fPoint.x, this.fPoint.y);
    }
}

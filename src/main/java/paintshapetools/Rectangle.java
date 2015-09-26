package paintshapetools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import painttools.StrokeStyleEnum;

public class Rectangle extends PlaneFigure
{
    protected Point sPoint;
    protected Point fPoint;

    public Rectangle(Color lineClr, Color fillClr, Point pt1, Point pt2, StrokeStyleEnum style)
    {
        this.fillColor=fillClr;
        this.lineColor=lineClr;
        this.fPoint=pt1;
        this.sPoint=pt2;
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(fillColor);
        g2d.setStroke(lineStroke);

        if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y < 0)
        {
            g2d.fillRect(this.fPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            g2d.setPaint(lineColor);
            g2d.drawRect(this.fPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
        }

        if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y < 0)
        {
            g2d.fillRect(this.sPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            g2d.setPaint(lineColor);
            g2d.drawRect(this.sPoint.x, this.fPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
        }

        if(this.fPoint.x - this.sPoint.x > 0 && this.fPoint.y - this.sPoint.y > 0)
        {
            g2d.fillRect(this.sPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            g2d.setPaint(lineColor);
            g2d.drawRect(this.sPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
        }

        if(this.fPoint.x - this.sPoint.x < 0 && this.fPoint.y - this.sPoint.y > 0)
        {
            g2d.fillRect(this.fPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
            g2d.setPaint(lineColor);
            g2d.drawRect(this.fPoint.x, this.sPoint.y, Math.abs(this.fPoint.x - this.sPoint.x), Math.abs(this.fPoint.y - this.sPoint.y));
        }
    }
}

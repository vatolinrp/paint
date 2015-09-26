package paintapplication;

import java.awt.Color;
import java.awt.Point;

public class DrawingTool
{
    private Point sPoint;
    private Point fPoint;
    private Figure element;
    private Point pPoint;
    private Point cPoint;
    private boolean isDrawing;
    private Color lineColor;
    private Color fillColor;

    public Point getSPoint()
    {
        return this.sPoint;
    }

    public void setSPoint(Point pt)
    {
        this.sPoint = pt;
    }

    public Point getFPoint()
    {
        return this.fPoint;
    }

    public void setFPoint(Point pt)
    {
        this.fPoint = pt;
    }

    public Figure getElement()
    {
        return this.element;
    }

    public void setElement(Figure element)
    {
        this.element = element;
    }

    public void setPPoint(Point pt)
    {
        this.pPoint = pt;
    }

    public Point getPPoint()
    {
        return this.pPoint;
    }

    public void setCPoint(Point pt)
    {
        this.cPoint = pt;
    }

    public Point getCPoint()
    {
        return this.cPoint;
    }

    public Color getLineColor()
    {
        return lineColor;
    }

    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
    }

    public Color getFillColor()
    {
        return fillColor;
    }

    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }

    public boolean isDrawing()
    {
        return this.isDrawing;
    }

    public void setDrawing(boolean b)
    {
        this.isDrawing = b;
    }
}

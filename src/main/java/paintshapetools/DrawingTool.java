package paintshapetools;

import java.awt.Color;
import java.awt.Point;

import paintdrawtools.Figure;
import painttools.AbstractTool;

public class DrawingTool extends AbstractTool
{
    Point sPoint;
    Point fPoint;
    Figure element;


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
}

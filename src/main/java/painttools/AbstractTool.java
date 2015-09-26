package painttools;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class AbstractTool implements Serializable
{
    protected Point pPoint;
    protected Point cPoint;
    protected StrokeStyleEnum strokeStyle;
    protected boolean isDrawing;
    protected Color lineColor;
    protected Color fillColor;



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

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public StrokeStyleEnum getStrokeStyle()
    {
        return this.strokeStyle;
    }

    public void setStrokeStyle(StrokeStyleEnum style)
    {
        this.strokeStyle = style;
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

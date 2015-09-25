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
    protected Color color;

    public AbstractTool(Color clr)
    {
        this.color = clr;
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

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color clr)
    {
        this.color = clr;
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

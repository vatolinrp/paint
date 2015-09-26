package paintapplication;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure
{
    protected Color lineColor;

    protected BasicStroke lineStroke = new BasicStroke((float)5);

    public abstract void draw(Graphics graphics);
}

package paintdrawtools;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable
{
    protected Color lineColor;

    protected BasicStroke lineStroke = new BasicStroke((float)5);

    public abstract void draw(Graphics graphics);
}

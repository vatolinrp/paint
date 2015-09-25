package painttools;

import java.awt.Color;
import java.awt.Graphics;
import paintdrawtools.PaintElement;

public abstract class PaintTool extends AbstractTool
{
    protected PaintElement element;

    public PaintTool(Color clr)
    {
        super(clr);
        this.isDrawing = false;
    }

    public PaintElement getElement()
    {
        return this.element;
    }

    public abstract void drawElement(Graphics var1);
}

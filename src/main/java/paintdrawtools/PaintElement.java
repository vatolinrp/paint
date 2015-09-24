//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintdrawtools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import painttools.StrokeStyleEnum;

public abstract class PaintElement implements Serializable {
    protected Point coors;
    protected Color color;
    protected StrokeStyleEnum strokeStyle;
    protected int strokeWidth;

    public PaintElement(Point pt, Color clr, int dim, StrokeStyleEnum style) {
        this.coors = pt;
        this.color = clr;
        this.strokeStyle = style;
        this.strokeWidth = dim;
    }

    public PaintElement(Point pt, Color clr, int dim) {
        this.coors = pt;
        this.color = clr;
        this.strokeWidth = dim;
        this.strokeStyle = StrokeStyleEnum.FILL_RECT;
    }

    public PaintElement(Color clr, int dim, StrokeStyleEnum style) {
        this.color = clr;
        this.strokeWidth = dim;
        this.strokeStyle = style;
    }

    public PaintElement(Color clr) {
        this.color = clr;
    }

    public PaintElement() {
    }

    public Point getCoors() {
        return this.coors;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public int getStroke() {
        return this.strokeWidth;
    }

    public void setStrokeWidth(int str) {
        this.strokeWidth = str;
    }

    public StrokeStyleEnum getStrokeStyle() {
        return this.strokeStyle;
    }

    public void setStrokeStyle(StrokeStyleEnum style) {
        this.strokeStyle = style;
    }

    public abstract void update(Graphics var1);
}

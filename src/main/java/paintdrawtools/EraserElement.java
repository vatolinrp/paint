//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintdrawtools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import paintapplication.Main;
import paintdrawtools.BrushElement;
import painttools.StrokeStyle;

public class EraserElement extends BrushElement {
    public EraserElement(Point pt, Color clr, int dim, StrokeStyle style) {
        super(pt, clr, dim, style);
    }

    public void update(Graphics g) {
        if(this.strokeStyle == StrokeStyle.DOT_CIRC) {
            g.setColor(Main.paint.drawPanel.getBackground());
            g.fillOval(this.coors.x, this.coors.y, this.strokeWidth, this.strokeWidth);
        }

        if(this.strokeStyle != StrokeStyle.DOT_CIRC) {
            g.setColor(Main.paint.drawPanel.getBackground());
            g.fillRect(this.coors.x, this.coors.y, this.strokeWidth, this.strokeWidth);
        }

    }
}

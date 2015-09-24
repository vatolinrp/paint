//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintdrawtools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import paintdrawtools.PencilElement;
import painttools.StrokeStyle;

public class AirBrushElement extends PencilElement {
    boolean newElement = true;
    int[][] points;

    public AirBrushElement(Point pt, Color clr, int dim, StrokeStyle style) {
        super(pt, clr, dim, style);
    }

    public void update(Graphics g) {
        g.setColor(this.color);
        if(this.newElement) {
            Random i = new Random();
            this.points = new int[this.strokeWidth * this.strokeWidth / 10][2];

            for(int i1 = 0; i1 < this.strokeWidth * this.strokeWidth / 10; ++i1) {
                int[] pts = new int[2];

                do {
                    pts[0] = i.nextInt(this.strokeWidth);
                    pts[1] = i.nextInt(this.strokeWidth);
                } while(!this.isNew(pts));

                g.drawRect(this.coors.x + pts[0], this.coors.y + pts[1], 1, 1);
                this.points[i1] = pts;
            }

            this.newElement = false;
        } else {
            for(int var5 = 0; var5 < this.points.length; ++var5) {
                g.drawRect(this.coors.x + this.points[var5][0], this.coors.y + this.points[var5][1], 1, 1);
            }
        }

    }

    public boolean isNew(int[] pts) {
        for(int i = 0; i < this.points.length; ++i) {
            if(pts == this.points[i]) {
                return false;
            }
        }

        return true;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintvisuals;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import paintapplication.Main;
import painttools.StrokeStyle;

public class ToolOptionIcon extends JPanel {
    protected StrokeStyle style;

    public ToolOptionIcon(StrokeStyle style) {
        this.style = style;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Main.paint.drawPanel.tool.getColor());
        if(this.style == StrokeStyle.DOT_CIRC) {
            g.fillOval(this.getWidth() / 7, this.getHeight() / 7, this.getWidth() / 7, this.getHeight() / 7 * 4);
            g.fillOval(this.getWidth() / 7 * 3, this.getHeight() / 7, this.getWidth() / 7, this.getHeight() / 7 * 4);
            g.fillOval(this.getWidth() / 7 * 5, this.getHeight() / 7, this.getWidth() / 7, this.getHeight() / 7 * 4);
        } else if(this.style == StrokeStyle.DOT_RECT) {
            g.fillRect(this.getWidth() / 7, this.getHeight() / 7, this.getWidth() / 7, this.getHeight() / 7 * 4);
            g.fillRect(this.getWidth() / 7 * 3, this.getHeight() / 7, this.getWidth() / 7, this.getHeight() / 7 * 4);
            g.fillRect(this.getWidth() / 7 * 5, this.getHeight() / 7, this.getWidth() / 7, this.getHeight() / 7 * 4);
        } else if(this.style == StrokeStyle.LINE) {
            g.fillRect(this.getWidth() / 9, this.getHeight() / 9 * 4, this.getWidth() / 9 * 7 + this.getWidth() / 9 * 2 / 3, this.getHeight() / 9 * 2);
        } else if(this.style == StrokeStyle.LINE_DASHED) {
            g.fillRect(this.getWidth() / 9 * 1, this.getHeight() / 9 * 4, this.getWidth() / 9 * 3 / 2, this.getHeight() / 9 * 2);
            g.fillRect(this.getWidth() / 9 * 4, this.getHeight() / 9 * 4, this.getWidth() / 9 * 3 / 2, this.getHeight() / 9 * 2);
            g.fillRect(this.getWidth() / 9 * 7, this.getHeight() / 9 * 4, this.getWidth() / 9 * 3 / 2, this.getHeight() / 9 * 2);
        }

        if(this.style == StrokeStyle.OPEN_RECT) {
            g.drawRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyle.OPEN_OVAL) {
            g.drawOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyle.FILL_RECT) {
            g.fillRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyle.FILL_OVAL) {
            g.fillOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyle.FILL_ROUND_RECT) {
            g.fillRoundRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3, 10, 10);
        } else if(this.style == StrokeStyle.OPEN_ROUND_RECT) {
            g.drawRoundRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3, 10, 10);
        }

        g.setColor(Color.black);
        if(this.style == StrokeStyle.SQUARE) {
            g.drawRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyle.CIRCLE) {
            g.drawOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        }

    }
}

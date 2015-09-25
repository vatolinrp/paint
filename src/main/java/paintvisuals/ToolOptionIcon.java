//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintvisuals;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import paintapplication.Main;
import painttools.StrokeStyleEnum;

public class ToolOptionIcon extends JPanel {
    protected StrokeStyleEnum style;

    public ToolOptionIcon(StrokeStyleEnum style) {
        this.style = style;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Main.paint.drawPanel.tool.getColor());
        if(this.style == StrokeStyleEnum.LINE) {
            g.fillRect(this.getWidth() / 9, this.getHeight() / 9 * 4, this.getWidth() / 9 * 7 + this.getWidth() / 9 * 2 / 3, this.getHeight() / 9 * 2);
        }

        if(this.style == StrokeStyleEnum.OPEN_RECT) {
            g.drawRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyleEnum.OPEN_OVAL) {
            g.drawOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyleEnum.FILL_RECT) {
            g.fillRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyleEnum.FILL_OVAL) {
            g.fillOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        }

        g.setColor(Color.black);
        if(this.style == StrokeStyleEnum.SQUARE) {
            g.drawRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        } else if(this.style == StrokeStyleEnum.CIRCLE) {
            g.drawOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
        }

    }
}

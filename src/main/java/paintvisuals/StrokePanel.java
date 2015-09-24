//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintvisuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import paintapplication.Main;
import painttools.StrokeStyle;

public class StrokePanel extends JPanel {
    public StrokeStyle style;

    public StrokePanel() {
        this.setPreferredSize(new Dimension(84, 84));
        this.style = StrokeStyle.DOT_RECT;
    }

    public void setStyle(StrokeStyle style) {
        this.style = style;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Main.paint.drawPanel.tool.getColor());
        if(this.style == StrokeStyle.DOT_RECT || this.style == StrokeStyle.SQUARE || this.style == StrokeStyle.LINE || this.style == StrokeStyle.FILL_RECT) {
            g.fillRect(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
            g.setColor(Color.black);
            g.drawRect(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

        if(this.style == StrokeStyle.DOT_CIRC || this.style == StrokeStyle.CIRCLE || this.style == StrokeStyle.FILL_OVAL) {
            g.fillOval(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
            g.setColor(Color.black);
            g.drawOval(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

        if(this.style == StrokeStyle.OPEN_OVAL) {
            g.drawOval(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

        if(this.style == StrokeStyle.OPEN_RECT) {
            g.drawRect(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

    }
}

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
import painttools.StrokeStyleEnum;

public class StrokePanel extends JPanel {
    public StrokeStyleEnum style;

    public StrokePanel() {
        this.setPreferredSize(new Dimension(84, 84));
        this.style = StrokeStyleEnum.DOT_RECT;
    }

    public void setStyle(StrokeStyleEnum style) {
        this.style = style;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Main.paint.drawPanel.tool.getColor());
        if(this.style == StrokeStyleEnum.DOT_RECT || this.style == StrokeStyleEnum.SQUARE || this.style == StrokeStyleEnum.LINE || this.style == StrokeStyleEnum.FILL_RECT) {
            g.fillRect(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
            g.setColor(Color.black);
            g.drawRect(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

        if(this.style == StrokeStyleEnum.DOT_CIRC || this.style == StrokeStyleEnum.CIRCLE || this.style == StrokeStyleEnum.FILL_OVAL) {
            g.fillOval(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
            g.setColor(Color.black);
            g.drawOval(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

        if(this.style == StrokeStyleEnum.OPEN_OVAL) {
            g.drawOval(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

        if(this.style == StrokeStyleEnum.OPEN_RECT) {
            g.drawRect(this.getWidth() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, this.getHeight() / 2 - Main.paint.drawPanel.tool.getStroke() / 2, Main.paint.drawPanel.tool.getStroke(), Main.paint.drawPanel.tool.getStroke());
        }

    }
}

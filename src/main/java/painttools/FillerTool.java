//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package painttools;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;
import paintapplication.Main;
import paintdrawtools.BrushElement;
import painttools.AbstractTool;
import painttools.StrokeStyle;

public class FillerTool extends AbstractTool {
    public FillerTool(Color clr, int stroke) {
        super(clr, stroke);
    }

    public void fillAllSides(Point point, Color color) {
        try {
            System.out.println(point);
            Robot robot = new Robot();
            Color[] exception = new Color[]{robot.getPixelColor(point.x - 1, point.y), robot.getPixelColor(point.x + 1, point.y), robot.getPixelColor(point.x, point.y + 1), robot.getPixelColor(point.x, point.y - 1)};
            robot = null;
            if(exception[0] != Main.paint.drawPanel.getBackground()) {
                robot.mouseMove(point.x - 1, point.y);
                Main.paint.drawPanel.elements.add(new BrushElement(Main.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                System.out.println(Main.paint.drawPanel.getMousePosition());
                Main.paint.drawPanel.repaint();
                this.fillAllSides(new Point(point.x - 1, point.y), color);
            }

            if(exception[1] == Main.paint.drawPanel.getBackground()) {
                robot.mouseMove(point.x - 1, point.y);
                Main.paint.drawPanel.elements.add(new BrushElement(Main.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                Main.paint.drawPanel.repaint();
                this.fillAllSides(new Point(point.x + 1, point.y), color);
            }

            if(exception[2] == Main.paint.drawPanel.getBackground()) {
                robot.mouseMove(point.x - 1, point.y);
                Main.paint.drawPanel.elements.add(new BrushElement(Main.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                Main.paint.drawPanel.repaint();
                this.fillAllSides(new Point(point.x, point.y + 1), color);
            }

            if(exception[3] == Main.paint.drawPanel.getBackground()) {
                robot.mouseMove(point.x - 1, point.y);
                Main.paint.drawPanel.elements.add(new BrushElement(Main.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                Main.paint.drawPanel.repaint();
                this.fillAllSides(new Point(point.x, point.y - 1), color);
            }
        } catch (AWTException var5) {
            var5.printStackTrace();
        }

    }
}

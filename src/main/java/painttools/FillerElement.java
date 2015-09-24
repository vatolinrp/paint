//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package painttools;

import java.awt.Color;
import java.awt.Graphics;
import paintapplication.Main;
import paintdrawtools.PaintElement;

public class FillerElement extends PaintElement {
    public FillerElement(Color clr) {
        super(clr);
    }

    public void update(Graphics g) {
        Main.paint.drawPanel.setBackground(this.color);
        Main.paint.drawPanel.backgroundColor = this.color;
        Main.paint.drawPanel.repaint();
    }
}

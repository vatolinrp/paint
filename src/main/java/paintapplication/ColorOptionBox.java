//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintapplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import paintapplication.Main;

public class ColorOptionBox extends JPanel {
    Color color;
    boolean selected;

    public ColorOptionBox(Color clr) {
        this.color = clr;
        this.selected = false;
        this.setBackground(this.color);
        this.setPreferredSize(new Dimension(48, 48));
        ColorOptionBox.MouseHandler handler = new ColorOptionBox.MouseHandler();
        this.addMouseListener(handler);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        if(this.selected) {
            g.setColor(Color.lightGray);
            g.drawRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.black);
            g.drawRect(-1, -1, this.getWidth(), this.getHeight());
        }

    }

    private class MouseHandler extends MouseAdapter {
        private MouseHandler() {
        }

        public void mousePressed(MouseEvent event) {
            Main.paint.colorPicker.deselectAll();
            ColorOptionBox.this.selected = true;
            Main.paint.drawPanel.setBrushColor(ColorOptionBox.this.color);
            Main.paint.colorPicker.currentClrPanel.setBackground(ColorOptionBox.this.color);
            Main.paint.repaint();
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseClicked(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }
    }
}

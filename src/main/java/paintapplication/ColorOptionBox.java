package paintapplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class ColorOptionBox extends JPanel
{
    private Color color;

    public ColorOptionBox(Color clr)
    {
        this.color = clr;
        this.setBackground(this.color);
        this.setPreferredSize(new Dimension(48, 48));
        ColorOptionBox.MouseHandler handler = new ColorOptionBox.MouseHandler();
        this.addMouseListener(handler);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
    }

    private class MouseHandler extends MouseAdapter
    {
        private MouseHandler()
        {
        }

        public void mousePressed(MouseEvent event)
        {
            if(event.getButton() == MouseEvent.BUTTON1)
            {
                Main.paint.drawPanel.setLineColor(ColorOptionBox.this.color);
            }
            if(event.getButton() == MouseEvent.BUTTON3)
            {
                Main.paint.drawPanel.setFillColor(ColorOptionBox.this.color);
            }
            Main.paint.repaint();
        }

        public void mouseReleased(MouseEvent event)
        {
        }

        public void mouseClicked(MouseEvent event)
        {
        }

        public void mouseEntered(MouseEvent event)
        {
        }
    }
}

package paintapplication;

import painttools.ToolEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenuBar extends JMenuBar
{
    JMenu file;
    JMenuItem quit;
    JMenuItem newSketch;
    JMenu elements;
    JMenuItem drawRectangle;
    JMenuItem drawEllipse;
    JMenuItem drawLine;

    PaintMenuBar()
    {
        PaintMenuBar.ItemHandler itemHandler = new PaintMenuBar.ItemHandler();

        file = new JMenu("File");
        elements = new JMenu("Elements");

        drawRectangle = new JMenuItem("Rectangle");
        drawEllipse = new JMenuItem("Ellipse");
        drawLine = new JMenuItem("Line");
        newSketch = new JMenuItem("New Drawing");
        quit = new JMenuItem("Quit");

        newSketch.addActionListener(itemHandler);
        quit.addActionListener(itemHandler);
        drawRectangle.addActionListener(itemHandler);
        drawEllipse.addActionListener(itemHandler);
        drawLine.addActionListener(itemHandler);

        file.add(this.newSketch);
        file.add(this.quit);

        elements.add(drawRectangle);
        elements.add(drawEllipse);
        elements.add(drawLine);

        add(this.file);
        add(this.elements);
    }

    private class ItemHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == PaintMenuBar.this.quit)
            {
                Main.paint.dispose();
                System.exit(0);
            }
            if (event.getSource() == PaintMenuBar.this.drawRectangle)
            {
                Main.paint.drawPanel.setTool(ToolEnum.RECTANGLE);
            }
            if (event.getSource() == PaintMenuBar.this.drawEllipse)
            {
                Main.paint.drawPanel.setTool(ToolEnum.OVAL);
            }
            if (event.getSource() == PaintMenuBar.this.drawLine)
            {
                Main.paint.drawPanel.setTool(ToolEnum.LINE);
            }
            Main.paint.repaint();
            PaintMenuBar.this.setFocusable(false);
        }
    }
}

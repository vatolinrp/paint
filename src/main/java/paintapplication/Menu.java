package paintapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar
{
    JMenu file;
    JMenuItem quit;
    JMenuItem newSketch;
    JMenu elements;
    JMenuItem drawRectangle;
    JMenuItem drawEllipse;
    JMenuItem drawLine;

    public Menu()
    {
        Menu.ItemHandler itemHandler = new Menu.ItemHandler();

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
            if( event.getSource() == Menu.this.newSketch)
            {
                Main.invalidate();
            }
            if (event.getSource() == Menu.this.quit)
            {
                Main.getPaintFrame().dispose();
                System.exit(0);
            }
            if (event.getSource() == Menu.this.drawRectangle)
            {
                Main.getPaintFrame().getDrawingPanel().setTool(FigureEnum.RECTANGLE);
            }
            if (event.getSource() == Menu.this.drawEllipse)
            {
                Main.getPaintFrame().getDrawingPanel().setTool(FigureEnum.OVAL);
            }
            if (event.getSource() == Menu.this.drawLine)
            {
                Main.getPaintFrame().getDrawingPanel().setTool(FigureEnum.LINE);
            }
            Main.getPaintFrame().repaint();
            Menu.this.setFocusable(false);
        }
    }
}

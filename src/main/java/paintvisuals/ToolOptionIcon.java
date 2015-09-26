package paintvisuals;

import java.awt.Graphics;
import javax.swing.JPanel;
import paintapplication.Main;
import painttools.StrokeStyleEnum;

/**
    This class draws icons on tool buttons
 */
public class ToolOptionIcon extends JPanel
{
    protected StrokeStyleEnum style;

    public ToolOptionIcon(StrokeStyleEnum style)
    {
        this.style = style;
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Main.paint.drawPanel.tool.getColor());
        switch (style)
        {
            case LINE:
            {
                g.fillRect(this.getWidth() / 9, this.getHeight() / 9 * 4, this.getWidth() / 9 * 7 + this.getWidth() / 9 * 2
                        / 3, this.getHeight() / 9 * 2);
                break;
            }
            case OPEN_RECT:
            {
                g.drawRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
                break;
            }
            case OPEN_OVAL:
            {
                g.drawOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
                break;
            }
            case FILL_RECT:
            {
                g.fillRect(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
                break;
            }
            case FILL_OVAL:
            {
                g.fillOval(this.getWidth() / 5, this.getHeight() / 5, this.getWidth() / 5 * 3, this.getHeight() / 5 * 3);
                break;
            }
        }
    }
}

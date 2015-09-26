package paintapplication;

import java.awt.*;
import javax.swing.*;

public class PaintFrame extends JFrame
{
    public DrawingPanel drawingPanel;
    protected Menu menuBar;
    private JPanel colorPanel;

    public PaintFrame()
    {
        this.setSize(1024, 768);
        this.setLayout(new BorderLayout());
        this.drawingPanel = new DrawingPanel();
        this.menuBar = new Menu();

        colorPanel = new JPanel();
        createColorBoxes();
        colorPanel.setBackground(Color.darkGray);
        colorPanel.setLayout(new GridLayout(4, 8, 5, 5));

        this.add(this.menuBar, "North");
        this.add(this.colorPanel, "South");
        this.add(new JScrollPane(this.drawingPanel), "Center");
        this.setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createColorBoxes()
    {
        for (int colorGrid = 1; colorGrid < 5; ++colorGrid)
        {
            for (int holder = 1; holder < 5; ++holder)
            {
                for (int holder2 = 1; holder2 < 3; ++holder2)
                {
                    colorPanel.add(new ColorBox(new Color(colorGrid * 51, holder * 51, holder2 * 127)));
                }
            }
        }
    }
}

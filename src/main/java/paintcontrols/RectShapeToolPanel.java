//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import paintapplication.Main;
import painttools.StrokeStyleEnum;
import painttools.ToolEnum;
import paintvisuals.ToolOptionIcon;

public class RectShapeToolPanel extends DragShapeToolPanel {
    JButton fillButton;
    JButton unFillButton;

    public RectShapeToolPanel(ToolEnum tool, int stroke) {
        super(tool, stroke);
        this.remove(this.buttonHolder);
        JPanel fillButtonPanel = new JPanel();
        fillButtonPanel.setLayout(new GridLayout(1, 2));
        fillButtonPanel.setBackground(Color.darkGray);
        fillButtonPanel.setPreferredSize(new Dimension(150, 50));
        this.fillButton = new JButton();
        this.unFillButton = new JButton();
        RectShapeToolPanel.ButtonListener listener = new RectShapeToolPanel.ButtonListener();
        this.fillButton.addActionListener(listener);
        this.unFillButton.addActionListener(listener);
        if(tool == ToolEnum.RECTANGLE) {
            this.fillButton.add(new ToolOptionIcon(StrokeStyleEnum.FILL_RECT));
            this.unFillButton.add(new ToolOptionIcon(StrokeStyleEnum.OPEN_RECT));
        }

        if(tool == ToolEnum.OVAL) {
            this.fillButton.add(new ToolOptionIcon(StrokeStyleEnum.FILL_OVAL));
            this.unFillButton.add(new ToolOptionIcon(StrokeStyleEnum.OPEN_OVAL));
        }

        if(tool == ToolEnum.ROUND_RECT) {
            this.fillButton.add(new ToolOptionIcon(StrokeStyleEnum.FILL_ROUND_RECT));
            this.unFillButton.add(new ToolOptionIcon(StrokeStyleEnum.OPEN_ROUND_RECT));
        }

        fillButtonPanel.add(this.fillButton);
        fillButtonPanel.add(this.unFillButton);
        this.add(fillButtonPanel);
        this.buttonHolder.setPreferredSize(new Dimension(100, 90));
        this.revalidate();
        this.repaint();
    }

    private class ButtonListener implements ActionListener {
        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == RectShapeToolPanel.this.fillButton) {
                switch(RectShapeToolPanel.this.tool) {
                    case RECTANGLE:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.FILL_RECT);
                        break;
                    case ROUND_RECT:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.FILL_ROUND_RECT);
                        break;
                    case OVAL:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.FILL_OVAL);
                }
            }

            if(event.getSource() == RectShapeToolPanel.this.unFillButton) {
                switch(RectShapeToolPanel.this.tool) {
                    case RECTANGLE:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.OPEN_RECT);
                        break;
                    case ROUND_RECT:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.OPEN_ROUND_RECT);
                        break;
                    case OVAL:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.OPEN_OVAL);
                }
            }

            RectShapeToolPanel.this.repaint();
        }
    }
}

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
import paintcontrols.DragShapeToolPanel;
import painttools.StrokeStyle;
import painttools.Tool;
import paintvisuals.ToolOptionIcon;

public class RectShapeToolPanel extends DragShapeToolPanel {
    JButton fillButton;
    JButton unFillButton;

    public RectShapeToolPanel(Tool tool, int stroke) {
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
        if(tool == Tool.RECTANGLE) {
            this.fillButton.add(new ToolOptionIcon(StrokeStyle.FILL_RECT));
            this.unFillButton.add(new ToolOptionIcon(StrokeStyle.OPEN_RECT));
        }

        if(tool == Tool.OVAL) {
            this.fillButton.add(new ToolOptionIcon(StrokeStyle.FILL_OVAL));
            this.unFillButton.add(new ToolOptionIcon(StrokeStyle.OPEN_OVAL));
        }

        if(tool == Tool.ROUND_RECT) {
            this.fillButton.add(new ToolOptionIcon(StrokeStyle.FILL_ROUND_RECT));
            this.unFillButton.add(new ToolOptionIcon(StrokeStyle.OPEN_ROUND_RECT));
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
                switch(RectShapeToolPanel.this.tool.ordinal()) {
                    case 1:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.FILL_RECT);
                        break;
                    case 2:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.FILL_ROUND_RECT);
                        break;
                    case 3:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.FILL_OVAL);
                }
            }

            if(event.getSource() == RectShapeToolPanel.this.unFillButton) {
                switch(RectShapeToolPanel.this.tool.ordinal()) {
                    case 1:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.OPEN_RECT);
                        break;
                    case 2:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.OPEN_ROUND_RECT);
                        break;
                    case 3:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.OPEN_OVAL);
                }
            }

            RectShapeToolPanel.this.repaint();
        }
    }
}

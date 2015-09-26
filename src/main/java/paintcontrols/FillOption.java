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

public class FillOption extends ToolOptionPanel {
    JButton fillButton;
    JButton unFillButton;

    public FillOption(ToolEnum tool) {
        super(tool);
        JPanel fillButtonPanel = new JPanel();
        fillButtonPanel.setLayout(new GridLayout(1, 2));
        fillButtonPanel.setBackground(Color.darkGray);
        fillButtonPanel.setPreferredSize(new Dimension(150, 50));
        this.fillButton = new JButton();
        this.unFillButton = new JButton();
        FillOption.ButtonListener listener = new FillOption.ButtonListener();
        this.fillButton.addActionListener(listener);
        this.unFillButton.addActionListener(listener);
        fillButtonPanel.add(this.fillButton);
        fillButtonPanel.add(this.unFillButton);
        this.add(fillButtonPanel);
        this.revalidate();
        this.repaint();
    }

    private class ButtonListener implements ActionListener {
        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == FillOption.this.fillButton) {
                switch(FillOption.this.tool) {
                    case RECTANGLE:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.FILL_RECT);
                        break;
                    case OVAL:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.FILL_OVAL);
                }
            }

            if(event.getSource() == FillOption.this.unFillButton) {
                switch(FillOption.this.tool) {
                    case RECTANGLE:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.OPEN_RECT);
                        break;
                    case OVAL:
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyleEnum.OPEN_OVAL);
                }
            }

            FillOption.this.repaint();
        }
    }
}

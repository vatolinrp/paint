//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import paintcontrols.BrushToolPanel;
import painttools.StrokeStyle;
import painttools.Tool;
import paintvisuals.ToolOptionIcon;

public class EraserToolPanel extends BrushToolPanel {
    public EraserToolPanel(Tool tool, int stroke) {
        super(tool, stroke);
        this.strokeSlider.setMaximum(64);
        this.strokeSlider.setMinimum(1);
        this.strokeSlider.setMajorTickSpacing(4);
        this.remove(this.buttonHolder);
        this.strokeStyles = new JButton[2];
        this.styleIcons = new ToolOptionIcon[2];
        this.styleIcons[0] = new ToolOptionIcon(StrokeStyle.CIRCLE);
        this.styleIcons[1] = new ToolOptionIcon(StrokeStyle.SQUARE);
        JPanel buttonHolder = new JPanel();
        buttonHolder.setBackground(Color.gray);
        buttonHolder.setLayout(new GridLayout(1, 2));
        buttonHolder.setPreferredSize(new Dimension(140, 64));

        for(int i = 0; i < this.strokeStyles.length; ++i) {
            this.strokeStyles[i] = new JButton();
            this.strokeStyles[i].setPreferredSize(new Dimension(150, 150));
            this.strokeStyles[i].addActionListener(this.handler);
            this.strokeStyles[i].add(this.styleIcons[i]);
            buttonHolder.add(this.strokeStyles[i]);
        }

        this.add(buttonHolder);
    }
}

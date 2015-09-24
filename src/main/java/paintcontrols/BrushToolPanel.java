//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import paintapplication.Main;
import paintcontrols.PencilToolPanel;
import painttools.StrokeStyle;
import painttools.Tool;
import paintvisuals.ToolOptionIcon;

public class BrushToolPanel extends PencilToolPanel {
    protected JButton[] strokeStyles;
    protected ToolOptionIcon[] styleIcons;
    protected BrushToolPanel.ButtonHandler handler;
    protected JPanel buttonHolder;

    public BrushToolPanel(Tool tool, int stroke) {
        super(tool, stroke);
        this.setLayout(new FlowLayout());
        this.strokeStyles = new JButton[3];
        this.styleIcons = new ToolOptionIcon[3];
        this.styleIcons[0] = new ToolOptionIcon(StrokeStyle.DOT_CIRC);
        this.styleIcons[1] = new ToolOptionIcon(StrokeStyle.DOT_RECT);
        this.styleIcons[2] = new ToolOptionIcon(StrokeStyle.LINE);
        this.handler = new BrushToolPanel.ButtonHandler();
        this.buttonHolder = new JPanel();
        this.buttonHolder.setBackground(Color.gray);
        this.buttonHolder.setPreferredSize(new Dimension(100, 100));
        this.buttonHolder.setLayout(new GridLayout(3, 1));

        for(int i = 0; i < this.strokeStyles.length; ++i) {
            this.strokeStyles[i] = new JButton();
            this.strokeStyles[i].addActionListener(this.handler);
            this.strokeStyles[i].add(this.styleIcons[i]);
            this.buttonHolder.add(this.strokeStyles[i]);
        }

        this.add(this.buttonHolder);
    }

    private class ButtonHandler implements ActionListener {
        private ButtonHandler() {
        }

        public void actionPerformed(ActionEvent event) {
            for(int i = 0; i < BrushToolPanel.this.strokeStyles.length; ++i) {
                if(event.getSource() == BrushToolPanel.this.strokeStyles[i]) {
                    Main.paint.drawPanel.tool.setStrokeStyle(BrushToolPanel.this.strokeStyleList[i]);
                    BrushToolPanel.this.showStroke.setStyle(Main.paint.drawPanel.tool.getStrokeStyle());
                    BrushToolPanel.this.repaint();
                    System.out.println("Style clicked: " + BrushToolPanel.this.strokeStyleList[i]);
                }
            }

        }
    }
}

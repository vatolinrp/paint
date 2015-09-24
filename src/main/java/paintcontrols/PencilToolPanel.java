//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintcontrols;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import paintapplication.Main;
import paintcontrols.ToolOptionPanel;
import painttools.StrokeStyle;
import painttools.Tool;
import paintvisuals.StrokePanel;

public class PencilToolPanel extends ToolOptionPanel {
    public StrokeStyle[] strokeStyleList;
    protected JSlider strokeSlider;
    protected JPanel showStrokePanel;
    protected StrokePanel showStroke;

    public PencilToolPanel(Tool tool, int stroke) {
        super(tool);
        this.strokeStyleList = new StrokeStyle[]{StrokeStyle.DOT_CIRC, StrokeStyle.DOT_RECT, StrokeStyle.LINE, StrokeStyle.TRIANGLE, StrokeStyle.RIBBON};
        this.setLayout(new FlowLayout());
        this.strokeSlider = new JSlider(0, 0, 16, 1);
        this.strokeSlider.setPaintTicks(false);
        this.strokeSlider.setMaximum(16);
        this.strokeSlider.setMinimum(1);
        this.strokeSlider.setMajorTickSpacing(1);
        this.strokeSlider.setValue(stroke);
        this.strokeSlider.revalidate();
        PencilToolPanel.SlideChangeListener listener = new PencilToolPanel.SlideChangeListener();
        this.strokeSlider.addChangeListener(listener);

        for(int i = 0; i < 3; ++i) {
            ;
        }

        this.showStroke = new StrokePanel();
        this.showStrokePanel = new JPanel();
        this.showStrokePanel.setPreferredSize(new Dimension(92, 92));
        this.showStrokePanel.setLayout(new FlowLayout());
        this.showStrokePanel.add(this.showStroke, "Center");
        this.add(this.showStrokePanel);
        this.add(this.strokeSlider);
    }

    private class SlideChangeListener implements ChangeListener {
        private SlideChangeListener() {
        }

        public void stateChanged(ChangeEvent event) {
            Main.paint.drawPanel.tool.setStrokeWidth(PencilToolPanel.this.strokeSlider.getValue());
            PencilToolPanel.this.repaint();
            System.out.println("Tool: " + Main.paint.drawPanel.tool + "  - - Stroke: " + Main.paint.drawPanel.tool.getStroke());
        }
    }
}

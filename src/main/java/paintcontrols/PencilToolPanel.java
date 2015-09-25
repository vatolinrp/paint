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
import painttools.StrokeStyleEnum;
import painttools.ToolEnum;

public class PencilToolPanel extends ToolOptionPanel {
    public StrokeStyleEnum[] strokeStyleList;
    protected JSlider strokeSlider;
    protected JPanel showStrokePanel;

    public PencilToolPanel(ToolEnum tool) {
        super(tool);
        this.strokeStyleList = new StrokeStyleEnum[]{StrokeStyleEnum.DOT_CIRC, StrokeStyleEnum.DOT_RECT, StrokeStyleEnum.LINE, StrokeStyleEnum.TRIANGLE, StrokeStyleEnum.RIBBON};
        this.setLayout(new FlowLayout());
        this.strokeSlider = new JSlider(0, 0, 16, 1);
        this.strokeSlider.setPaintTicks(false);
        this.strokeSlider.setMaximum(16);
        this.strokeSlider.setMinimum(1);
        this.strokeSlider.setMajorTickSpacing(1);
        this.strokeSlider.setValue(5);
        this.strokeSlider.revalidate();
        PencilToolPanel.SlideChangeListener listener = new PencilToolPanel.SlideChangeListener();
        this.strokeSlider.addChangeListener(listener);
        this.showStrokePanel = new JPanel();
        this.showStrokePanel.setPreferredSize(new Dimension(92, 92));
        this.showStrokePanel.setLayout(new FlowLayout());
        this.add(this.showStrokePanel);
        this.add(this.strokeSlider);
    }

    private class SlideChangeListener implements ChangeListener {
        private SlideChangeListener() {
        }

        public void stateChanged(ChangeEvent event) {
            PencilToolPanel.this.repaint();
            System.out.println("ToolEnum: " + Main.paint.drawPanel.tool);
        }
    }
}

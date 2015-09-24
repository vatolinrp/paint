//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintapplication;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import paintapplication.Main;
import paintcontrols.AirBrushToolPanel;
import paintcontrols.BrushToolPanel;
import paintcontrols.ColorPickerToolPanel;
import paintcontrols.DragShapeToolPanel;
import paintcontrols.EraserToolPanel;
import paintcontrols.PencilToolPanel;
import paintcontrols.RectShapeToolPanel;
import paintdrawtools.AirBrushElement;
import paintdrawtools.AirBrushTool;
import paintdrawtools.BrushElement;
import paintdrawtools.BrushTool;
import paintdrawtools.EraserElement;
import paintdrawtools.EraserTool;
import paintdrawtools.PaintElement;
import paintdrawtools.PencilElement;
import paintdrawtools.PencilTool;
import paintshapetools.DragTool;
import paintshapetools.LineElement;
import paintshapetools.LineTool;
import paintshapetools.OvalElement;
import paintshapetools.OvalTool;
import paintshapetools.RectangleElement;
import paintshapetools.RectangleTool;
import paintshapetools.RoundRectElement;
import paintshapetools.RoundRectTool;
import painttools.AbstractTool;
import painttools.FillerElement;
import painttools.FillerTool;
import painttools.StrokeStyle;
import painttools.Tool;

public class DrawPanel extends JPanel implements Runnable {
    public int frameCount;
    public ArrayList elements;
    protected Boolean mousePressed;
    protected boolean mouseClicked;
    public Tool currentTool;
    public AbstractTool tool;
    protected Color brushColor;
    public Color backgroundColor;
    protected Thread animator;

    public DrawPanel() {
        this.backgroundColor = Color.white;
        this.setBackground(this.backgroundColor);
        this.setPreferredSize(new Dimension(1024, 768));
        DrawPanel.MouseHandler handler = new DrawPanel.MouseHandler();
        this.addMouseListener(handler);
        this.elements = new ArrayList();
        this.elements.add(new FillerElement(this.getBackground()));
        this.mousePressed = Boolean.valueOf(false);
        this.brushColor = Color.black;
        this.tool = new PencilTool(this.brushColor, 1);
        this.currentTool = Tool.PENCIL;
        this.frameCount = -1;
    }

    public void startTheThread() {
        this.animator = new Thread(this);
        this.animator.start();
    }

    public void run() {
        while(true) {
            if(this.getMousePosition() != null) {
                if(this.isPaintingTool(this.currentTool)) {
                    if(!this.getMousePressed()) {
                        this.tool.setCPoint((Point)null);
                        this.tool.setDrawing(false);
                    }

                    if(this.tool.isDrawing()) {
                        if(this.getMousePosition() != this.tool.getCPoint()) {
                            if(this.getMousePressed()) {
                                this.tool.setPPoint(this.tool.getCPoint());
                                if(this.getMousePosition() != null) {
                                    this.tool.setCPoint(new Point(this.getMousePosition()));
                                }

                                if(this.currentTool == Tool.PENCIL) {
                                    this.elements.add(new PencilElement(this.tool.getPPoint(), this.tool.getCPoint(), this.tool.getColor(), this.tool.getStroke()));
                                }

                                if(this.currentTool == Tool.BRUSH) {
                                    this.elements.add(new BrushElement(this.tool.getPPoint(), this.tool.getCPoint(), this.tool.getColor(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                                }

                                if(this.currentTool == Tool.ERASER) {
                                    this.elements.add(new EraserElement(this.tool.getPPoint(), this.tool.getColor(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                                }

                                if(this.currentTool == Tool.AIRBRUSH) {
                                    this.elements.add(new AirBrushElement(this.tool.getPPoint(), this.tool.getColor(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                                }
                            }

                            this.repaint();
                        }
                    } else if(this.getMousePressed()) {
                        this.tool.setCPoint(this.getMousePosition());
                        this.tool.setDrawing(true);
                    }
                }

                if(this.isDraggingTool(this.currentTool)) {
                    if(this.tool.isDrawing() && this.getMousePosition() == null) {
                        this.tool.setDrawing(false);
                        this.mousePressed = Boolean.valueOf(false);
                    }

                    if(this.mousePressed.booleanValue()) {
                        if(!this.tool.isDrawing()) {
                            this.tool.setDrawing(true);
                            ((DragTool)this.tool).setSPoint(this.getMousePosition());
                            this.tool.setCPoint(this.getMousePosition());
                            this.addTemporaryDragElement(this.tool.getColor(), ((DragTool)this.tool).getSPoint(), this.tool.getCPoint(), this.tool.getStroke(), this.tool.getStrokeStyle());
                        }

                        if(this.getMousePosition() != this.tool.getCPoint()) {
                            ((DragTool)this.tool).setFPoint(this.getMousePosition());
                            this.tool.setPPoint(this.tool.getPPoint());
                            this.tool.setCPoint(this.getMousePosition());
                            this.elements.remove(this.elements.size() - 1);
                            this.addTemporaryDragElement(this.tool.getColor(), ((DragTool)this.tool).getSPoint(), this.tool.getCPoint(), this.tool.getStroke(), this.tool.getStrokeStyle());
                        }
                    }

                    if(this.tool.isDrawing() && !this.mousePressed.booleanValue()) {
                        this.tool.setDrawing(false);
                        this.elements.remove(this.elements.size() - 1);
                        switch(this.currentTool.ordinal()) {
                            case 1:
                                this.elements.add(new OvalElement(this.tool.getColor(), ((DragTool)this.tool).getSPoint(), ((DragTool)this.tool).getFPoint(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                                break;
                            case 2:
                                this.elements.add(new RectangleElement(this.tool.getColor(), ((DragTool)this.tool).getSPoint(), ((DragTool)this.tool).getFPoint(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                                break;
                            case 3:
                                this.elements.add(new RoundRectElement(this.tool.getColor(), ((DragTool)this.tool).getSPoint(), this.tool.getCPoint(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                                break;
                            case 4:
                                this.elements.add(new LineElement(this.tool.getColor(), ((DragTool)this.tool).getSPoint(), ((DragTool)this.tool).getFPoint(), this.tool.getStroke(), this.tool.getStrokeStyle()));
                        }
                    }

                    this.repaint();
                }

                if(this.currentTool == Tool.FILLER && this.mousePressed.booleanValue()) {
                    this.elements.set(0, new FillerElement(this.brushColor));
                    this.repaint();
                }

                ++this.frameCount;
            } else {
                this.tool.setDrawing(false);
                this.tool.setCPoint((Point)null);
            }

            if(this.currentTool == Tool.PICKER) {
                PointerInfo e = MouseInfo.getPointerInfo();

                try {
                    Robot robot = new Robot();
                    Main.paint.paintTools.toolOptionPanel.setColor(robot.getPixelColor(e.getLocation().x, e.getLocation().y));
                    if(this.mousePressed.booleanValue()) {
                        this.setBrushColor(Main.paint.paintTools.toolOptionPanel.getColor());
                        Main.paint.colorPicker.currentClrPanel.setBackground(Main.paint.paintTools.toolOptionPanel.getColor());
                        this.tool.setColor(Main.paint.paintTools.toolOptionPanel.getColor());
                        this.repaint();
                    }

                    robot = null;
                } catch (AWTException var5) {
                    var5.printStackTrace();
                }
            }

            try {
                Thread.sleep(10L);
            } catch (InterruptedException var4) {
                return;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < this.elements.size(); ++i) {
            ((PaintElement)this.elements.get(i)).update(g);
        }

    }

    public void addTemporaryDragElement(Color clr, Point sPoint, Point cPoint, int strokeW, StrokeStyle strokeS) {
        switch(this.currentTool.ordinal()) {
            case 1:
                this.elements.add(new OvalElement(clr, sPoint, cPoint, strokeW, strokeS));
                break;
            case 2:
                this.elements.add(new RectangleElement(clr, sPoint, cPoint, strokeW, strokeS));
                break;
            case 3:
                this.elements.add(new RoundRectElement(clr, sPoint, cPoint, strokeW, strokeS));
                break;
            case 4:
                this.elements.add(new LineElement(clr, sPoint, cPoint, strokeW, strokeS));
        }

    }

    public boolean isPaintingTool(Tool tool) {
        switch(tool.ordinal()) {
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public boolean isDraggingTool(Tool tool) {
        switch(tool.ordinal()) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public void setBrushColor(Color clr) {
        this.brushColor = clr;
        this.tool.setColor(clr);
    }

    public Color getBrushColor() {
        return this.brushColor;
    }

    public void setTool(Tool tool) {
        this.currentTool = tool;
        this.setPaintTool(tool);
        if(this.currentTool == Tool.PICKER && this.animator == null) {
            this.startTheThread();
        }

    }

    public Tool getTool() {
        return this.currentTool;
    }

    public void setPaintTool(Tool tool) {
        int stroke = this.tool.getStroke();
        if(tool != Tool.ERASER && stroke >= 16) {
            this.tool.setStrokeWidth(16);
        }

        switch(tool.ordinal()) {
            case 1:
                this.tool = new OvalTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new RectShapeToolPanel(Tool.OVAL, this.tool.getStroke()));
                break;
            case 2:
                this.tool = new RectangleTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new RectShapeToolPanel(Tool.RECTANGLE, this.tool.getStroke()));
                break;
            case 3:
                this.tool = new RoundRectTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new RectShapeToolPanel(Tool.ROUND_RECT, this.tool.getStroke()));
                break;
            case 4:
                this.tool = new LineTool(this.brushColor, this.tool.getStroke(), StrokeStyle.LINE);
                Main.paint.paintTools.setToolOptionPanel(new DragShapeToolPanel(Tool.LINE, this.tool.getStroke()));
                break;
            case 5:
                this.tool = new PencilTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new PencilToolPanel(Tool.PENCIL, this.tool.getStroke()));
                break;
            case 6:
                this.tool = new BrushTool(this.brushColor, this.tool.getStroke(), StrokeStyle.LINE);
                Main.paint.paintTools.setToolOptionPanel(new BrushToolPanel(Tool.BRUSH, this.tool.getStroke()));
                break;
            case 7:
                this.tool = new AirBrushTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new AirBrushToolPanel(Tool.AIRBRUSH, this.tool.getStroke()));
                break;
            case 8:
                this.tool = new EraserTool(this.getBackground(), this.tool.getStroke(), StrokeStyle.SQUARE);
                Main.paint.paintTools.setToolOptionPanel(new EraserToolPanel(Tool.ERASER, this.tool.getStroke()));
                break;
            case 9:
                this.tool = new FillerTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new PencilToolPanel(Tool.PENCIL, this.tool.getStroke()));
                break;
            case 10:
                this.tool = new FillerTool(this.brushColor, this.tool.getStroke());
                Main.paint.paintTools.setToolOptionPanel(new ColorPickerToolPanel(Tool.PICKER, this.brushColor));
        }

    }

    public boolean getMousePressed() {
        return this.mousePressed.booleanValue();
    }

    private class MouseHandler extends MouseAdapter {
        private MouseHandler() {
        }

        public void mousePressed(MouseEvent event) {
            if(DrawPanel.this.animator == null) {
                DrawPanel.this.startTheThread();
            }

            DrawPanel.this.mousePressed = Boolean.valueOf(true);
        }

        public void mouseReleased(MouseEvent event) {
            DrawPanel.this.mousePressed = Boolean.valueOf(false);
        }

        public void mouseClicked(MouseEvent event) {
            DrawPanel.this.mouseClicked = true;
        }

        public void mouseExited(MouseEvent event) {
            DrawPanel.this.mousePressed = Boolean.valueOf(false);
        }
    }
}

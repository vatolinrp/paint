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

import paintdrawtools.Figure;
import paintshapetools.DrawingTool;
import paintshapetools.Line;
import paintshapetools.Oval;
import paintshapetools.Rectangle;
import painttools.AbstractTool;
import painttools.StrokeStyleEnum;
import painttools.ToolEnum;

public class DrawPanel extends JPanel implements Runnable
{
    public int frameCount;
    public ArrayList elements;
    protected Boolean mousePressed;
    protected boolean mouseClicked;
    public ToolEnum currentTool;
    public DrawingTool tool;
    protected Color lineColor;
    protected Color fillColor;
    public Color backgroundColor;
    protected Thread animator;

    public DrawPanel()
    {
        this.backgroundColor = Color.white;
        this.setBackground(this.backgroundColor);
        this.setPreferredSize(new Dimension(600, 600));
        MouseHandler handler = new MouseHandler();
        this.addMouseListener(handler);
        this.elements = new ArrayList();
        this.mousePressed = Boolean.valueOf(false);
        this.lineColor = Color.black;
        this.fillColor = Color.green;
        this.tool = new DrawingTool();
        this.currentTool = ToolEnum.LINE;
        this.frameCount = -1;
    }

    public void startTheThread()
    {
        this.animator = new Thread(this);
        this.animator.start();
    }

    public void run()
    {
        while (true)
        {
            if (this.getMousePosition() != null)
            {
                    if (this.tool.isDrawing() && this.getMousePosition() == null)
                    {
                        this.tool.setDrawing(false);
                        this.mousePressed = Boolean.valueOf(false);
                    }

                    if (this.mousePressed.booleanValue())
                    {
                        if (!this.tool.isDrawing())
                        {
                            this.tool.setDrawing(true);
                            this.tool.setSPoint(this.getMousePosition());
                            this.tool.setCPoint(this.getMousePosition());
                            this.addTemporaryDragElement(this.tool.getLineColor(),this.tool.getFillColor(), this.tool.getSPoint(),
                                    this.tool.getCPoint(), this.tool.getStrokeStyle());
                        }

                        if (this.getMousePosition() != this.tool.getCPoint())
                        {
                            this.tool.setFPoint(this.getMousePosition());
                            this.tool.setPPoint(this.tool.getPPoint());
                            this.tool.setCPoint(this.getMousePosition());
                            this.elements.remove(this.elements.size() - 1);
                            this.addTemporaryDragElement(this.tool.getLineColor(),this.tool.getFillColor(), this.tool.getSPoint(),
                                    this.tool.getCPoint(), this.tool.getStrokeStyle());
                        }
                    }

                    if (this.tool.isDrawing() && !this.mousePressed.booleanValue())
                    {
                        this.tool.setDrawing(false);
                        this.elements.remove(this.elements.size() - 1);
                        switch (this.currentTool)
                        {
                        case OVAL:
                            this.elements.add(new Oval(this.tool.getLineColor(),this.tool.getFillColor(),
                                    this.tool.getSPoint(),
                                    this.tool.getFPoint()));
                            break;
                        case RECTANGLE:
                            this.elements.add(new Rectangle(this.tool.getLineColor(),this.tool.getFillColor(), this.tool
                                    .getSPoint(), this.tool.getFPoint(), this.tool.getStrokeStyle()));
                            break;
                        case LINE:
                            this.elements.add(new Line(this.tool.getLineColor(),
                                     this.tool.getSPoint(),
                                     this.tool.getFPoint()));
                        }
                    }

                    this.repaint();


                ++this.frameCount;
            }
            else
            {
                this.tool.setDrawing(false);
                this.tool.setCPoint((Point) null);
            }

            try
            {
                Thread.sleep(10L);
            }
            catch (InterruptedException var4)
            {
                return;
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (int i = 0; i < this.elements.size(); ++i)
        {
            ((Figure) this.elements.get(i)).draw(g);
        }

    }

    public void addTemporaryDragElement(Color lineClr, Color fillClr, Point sPoint, Point cPoint, StrokeStyleEnum strokeS)
    {
        switch (currentTool)
        {
            case OVAL:
            {
                this.elements.add(new Oval(lineClr, fillClr, sPoint, cPoint));
                break;
            }

            case RECTANGLE:
            {
                this.elements.add(new Rectangle(lineClr, fillClr, sPoint, cPoint, strokeS));
                break;
            }
            case LINE:
            {
                this.elements.add(new Line(lineClr, sPoint, cPoint));
                break;
            }
        }

    }

    public void setLineColor(Color clr)
    {
        lineColor = clr;
        tool.setLineColor(clr);
    }

    public void setFillColor(Color clr)
    {
        fillColor = clr;
        tool.setFillColor(clr);
    }

    public void setTool(ToolEnum tool)
    {
        this.currentTool = tool;
    }

    public ToolEnum getTool()
    {
        return this.currentTool;
    }

    private class MouseHandler extends MouseAdapter
    {
        private MouseHandler()
        {
        }

        public void mousePressed(MouseEvent event)
        {
            if (DrawPanel.this.animator == null)
            {
                DrawPanel.this.startTheThread();
            }

            DrawPanel.this.mousePressed = Boolean.valueOf(true);
        }

        public void mouseReleased(MouseEvent event)
        {
            DrawPanel.this.mousePressed = Boolean.valueOf(false);
        }

        public void mouseClicked(MouseEvent event)
        {
            DrawPanel.this.mouseClicked = true;
        }

        public void mouseExited(MouseEvent event)
        {
            DrawPanel.this.mousePressed = Boolean.valueOf(false);
        }
    }
}

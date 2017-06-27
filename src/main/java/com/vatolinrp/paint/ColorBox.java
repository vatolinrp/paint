package com.vatolinrp.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class ColorBox extends JPanel
{
  private Color color;

  public ColorBox( Color clr )
  {
    this.color = clr;
    this.setBackground( this.color );
    this.setPreferredSize( new Dimension( 48, 48 ) );
    ColorBox.MouseHandler handler = new ColorBox.MouseHandler();
    this.addMouseListener( handler );
  }

  public void paintComponent( Graphics g )
  {
    super.paintComponent( g );
    g.setColor( Color.lightGray );
    g.drawRect( 0, 0, this.getWidth(), this.getHeight() );
  }

  private class MouseHandler extends MouseAdapter
  {
    private MouseHandler()
    {
    }

    public void mousePressed( MouseEvent event )
    {
      if ( event.getButton() == MouseEvent.BUTTON1 ) {
        Main.getPaintFrame().getDrawingPanel().setLineColor( ColorBox.this.color );
      }
      if ( event.getButton() == MouseEvent.BUTTON3 ) {
        Main.getPaintFrame().getDrawingPanel().setFillColor( ColorBox.this.color );
      }
      Main.getPaintFrame().repaint();
    }

    public void mouseReleased( MouseEvent event )
    {
    }

    public void mouseClicked( MouseEvent event )
    {
    }

    public void mouseEntered( MouseEvent event )
    {
    }
  }
}

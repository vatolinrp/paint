package com.vatolinrp.paintapplication.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends PlaneFigure
{
  private Point sPoint;
  private Point fPoint;

  public Rectangle( Color lineClr, Color fillClr, Point pt1, Point pt2 )
  {
    fillColor = fillClr;
    lineColor = lineClr;
    fPoint = pt1;
    sPoint = pt2;
  }

  public void draw( Graphics g )
  {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setPaint( fillColor );
    g2d.setStroke( lineStroke );

    if ( fPoint.x - sPoint.x < 0 && fPoint.y - sPoint.y < 0 ) {
      g2d.fillRect( fPoint.x, fPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
      g2d.setPaint( lineColor );
      g2d.drawRect( fPoint.x, fPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
    }

    if ( fPoint.x - sPoint.x > 0 && fPoint.y - sPoint.y < 0 ) {
      g2d.fillRect( sPoint.x, fPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
      g2d.setPaint( lineColor );
      g2d.drawRect( sPoint.x, fPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
    }

    if ( fPoint.x - sPoint.x > 0 && fPoint.y - sPoint.y > 0 ) {
      g2d.fillRect( sPoint.x, sPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
      g2d.setPaint( lineColor );
      g2d.drawRect( sPoint.x, sPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
    }

    if ( fPoint.x - sPoint.x < 0 && fPoint.y - sPoint.y > 0 ) {
      g2d.fillRect( fPoint.x, sPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
      g2d.setPaint( lineColor );
      g2d.drawRect( fPoint.x, sPoint.y, Math.abs( fPoint.x - sPoint.x ), Math.abs( fPoint.y - sPoint.y ) );
    }
  }
}

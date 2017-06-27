package com.vatolinrp.paint.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure
{
  protected Color lineColor;

  protected BasicStroke lineStroke = new BasicStroke( (float)5 );

  public abstract void draw( Graphics graphics );
}

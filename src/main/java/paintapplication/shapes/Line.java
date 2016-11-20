package paintapplication.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Figure
{
  protected Point sPoint;
  protected Point fPoint;

  public Line( Color clr, Point pt1, Point pt2 )
  {
    this.sPoint = pt1;
    this.fPoint = pt2;
    this.lineColor = clr;
  }

  public void draw( Graphics g )
  {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setPaint( this.lineColor );
    g2d.setStroke( new BasicStroke( (float)5, 1, 1 ) );
    g2d.drawLine( this.sPoint.x, this.sPoint.y, this.fPoint.x, this.fPoint.y );
  }
}

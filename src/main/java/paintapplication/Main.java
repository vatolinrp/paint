package paintapplication;

public class Main
{
  private static PaintFrame paintFrame;

  public static void main( String[] args )
  {
    paintFrame = new PaintFrame();
  }

  public static PaintFrame getPaintFrame()
  {
    return paintFrame;
  }

  public static void invalidate()
  {
    paintFrame.dispose();
    paintFrame = new PaintFrame();
  }
}

package com.vatolinrp.paintapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PaintFrame extends JFrame
{
  private DrawingPanel drawingPanel;
  private Menu menu;
  private JPanel colorPanel;

  public PaintFrame()
  {
    setSize( 1024, 768 );
    setLayout( new BorderLayout() );
    drawingPanel = new DrawingPanel();
    menu = new Menu();

    colorPanel = new JPanel();
    createColorBoxes();
    colorPanel.setBackground( Color.darkGray );
    colorPanel.setLayout( new GridLayout( 4, 8, 5, 5 ) );

    this.add( menu, "North" );
    this.add( this.colorPanel, "South" );
    this.add( new JScrollPane( this.drawingPanel ), "Center" );
    this.setDefaultCloseOperation( 3 );
    setLocationRelativeTo( null );
    this.setVisible( true );
  }

  private void createColorBoxes()
  {
    for( int colorGrid = 1; colorGrid < 5; ++colorGrid ) {
      for( int holder = 1; holder < 5; ++holder ) {
        for( int holder2 = 1; holder2 < 3; ++holder2 ) {
          colorPanel.add( new ColorBox( new Color( colorGrid * 51, holder * 51, holder2 * 127 ) ) );
        }
      }
    }
  }

  public DrawingPanel getDrawingPanel()
  {
    return drawingPanel;
  }

  public Menu getMenu()
  {
    return menu;
  }

  public JPanel getColorPanel()
  {
    return colorPanel;
  }
}

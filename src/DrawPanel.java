/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phil
 */
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Drawing panel for the lines and the moving rectangle
 */
public class DrawPanel extends JPanel
  implements MouseListener, MouseMotionListener, ComponentListener {
  // Rectangle to move around
  static int widthX = 10;
  static int heightY = 20;
  Rectangle rect = new Rectangle(0, 0, widthX, heightY);

  // Holds the coordinates of the user's last mousePressed event.
  int last_x, last_y;

  // Size of the JPanel
  Rectangle area;

  // State variables
  // first time paint
  boolean firstTime = true;
  // True if the user pressed, dragged or released the mouse outside of
  // the rectangle; false otherwise.
  boolean pressOut = false;

  public DrawPanel(){
    setBackground(Color.white);
    // Register mouse and resize event listeners
    addMouseMotionListener(this);
    addMouseListener(this);
    addComponentListener(this);
  }


  /**
   * Handles the event of the user pressing down the mouse button.
   */
  public void mousePressed(MouseEvent e){
    last_x = rect.x - e.getX();
    last_y = rect.y - e.getY();

    // Checks whether or not the cursor is inside of the rectangle
    // while the user is pressing the mouse.
    if ( rect.contains(e.getX(), e.getY()) ) {
      updateLocation(e);
      updateIntersectionCount();
    } else {
      //LineIntersection.status.setText("First position the cursor on the rectangle and then drag.");
      pressOut = true;
    }
  }

  /**
   * Handles the event of a user dragging the mouse while holding down
   * the mouse button.
   */
  public void mouseDragged(MouseEvent e){
    if ( !pressOut ) {
      updateLocation(e);
      updateIntersectionCount();
    } else {
      //LineIntersection.status.setText("First position the cursor on the rectangle and then drag.");
    }
  }

  /**
   *  Handles the event of a user releasing the mouse button.
   */
  public void mouseReleased(MouseEvent e){
    // Checks whether or not the cursor is inside of the rectangle
    // when the user releases the mouse button.
    if ( rect.contains(e.getX(), e.getY()) ) {
      updateLocation(e);
      updateIntersectionCount();
    } else {
      //LineIntersection.status.setText("First position the cursor on the rectangle and then drag.");
      pressOut = false;
    }
  }

  /**
   * Handle event of LinePanel being resized
   */
  public void componentResized(ComponentEvent e) {
    Dimension dim = getSize();
    area = new Rectangle(dim);
  }

  // This method is required by MouseListener.
  public void mouseMoved(MouseEvent e){}

  // These methods are required by MouseMotionListener.
  public void mouseClicked(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}

  // Needed for ComponentListener
  public void componentHidden(ComponentEvent e) {}
  public void componentMoved(ComponentEvent e) {}
  public void componentShown(ComponentEvent e) {}


  // Updates the coordinates representing the location of the current
  // rectangle.
  public void updateLocation(MouseEvent e){
    rect.setLocation(last_x + e.getX(), last_y + e.getY());
    // Updates the status to reflect the location of the current
    // rectangle if checkRect returns true; otherwise, returns error
    // message.
    if (checkRect()) {
      //LineIntersection.status.setText("Rectangle located at " +
				    //rect.getX() + ", " +
				    //rect.getY());
    } else {
      //LineIntersection.status.setText("Can't "+
	//			      " drag outside the area.");
    }
    repaint();
  }

  public void updateIntersectionCount() {
    //int count = lSet.intersect(rect);
    //double min = lSet.distance(rect);
    //LineIntersection.counter.setText("Covering: " +
				//     count +
				//     " lines. Distance to center: " +
				//     min );
  }

  /**
   * The drawing routine
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setStroke(new BasicStroke(2.0f));
    Dimension dim = getSize();
    int w = (int)dim.getWidth();
    int h = (int)dim.getHeight();
    if ( firstTime ) {
      area = new Rectangle(dim);
      //lSet = new LineSet( noLines, area );
      rect.setLocation(w/2-widthX/2, h/2-heightY);
      updateIntersectionCount();
      firstTime = false;
    }
    // Clears the rectangle that was previously drawn.
    g2.setPaint(Color.white);
    g2.fillRect(0, 0, w, h);

    // Draw the line segment
    g2.setPaint(Color.red);
    //lSet.paint(g2);

    // Draws and fills the newly positioned rectangle.
    g2.setPaint(Color.blue);
    g2.fill(rect);
  }

  /**
   * Checks if the rectangle is contained within the panel. If
   * the rectangle is not contained within the panel, it is
   * redrawn so that it is adjacent to the edge of the window and just
   * inside the window.
   */
  boolean checkRect(){

    if (area == null) {
      return false;
    }

    if(area.contains(rect.x, rect.y, widthX, heightY)){
      return true;
    }
    int new_x = rect.x;
    int new_y = rect.y;

    if((rect.x+widthX)>area.getWidth()){
      new_x = (int)area.getWidth()-widthX+1;
    }
    if(rect.x < 0){
      new_x = -1;
    }
    if((rect.y+heightY)>area.getHeight()){
      new_y = (int)area.getHeight()-heightY+1;
    }
    if(rect.y < 0){
      new_y = -1;
    }
    rect.setLocation(new_x, new_y);
    return false;
  }
}

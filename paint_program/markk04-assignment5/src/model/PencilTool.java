/**
 * TCSS 305 assignment 5
 */
package model;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * a sub class Pencil Tool for the abstract class AbstractPaint, this class is 
 * different from the other sub classes because you need to construct a path for 
 * the drawn outline.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class PencilTool extends AbstractPaintTool {
    
    /**
     * the path of the outline being drawn.
     */
    private Path2D myPath;
    
    /**
     * Constructs the path.
     */
    public PencilTool() {
        // create the path
        super();
        myPath = new Path2D.Double();
    }
    
    /**
     * create the path to draw on the panel.
     * 
     * @return the path being drawn.
     */
    @Override
    public Shape getShape() {
       
        return myPath;
    }
    /**
     * set the start point of the path.
     */
    @Override
    public void setStartPoint(final Point2D theStart) {
        // create the new path each time
        myPath = new Path2D.Double();
        myPath.moveTo(theStart.getX(), theStart.getY());
    }

    /**
     * set the end point of the path.
     */
    @Override
    public void setEndPoint(final Point2D theEnd) {
        // set the end point of the outline
        super.setEndPoint(theEnd);
        myPath.lineTo(theEnd.getX(), theEnd.getY());
    }
  
    
    
    

}

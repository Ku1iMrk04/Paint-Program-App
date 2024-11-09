/**
 * TCSS 305 assignment 5
 */
package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * The parent abstract class for all of the tools from the sub child classes.
 * 
 * @author Mark Kulibaba
 * @version 4.0
 */
public abstract class AbstractPaintTool implements PaintTool {
    
    /** A point outside the drawing area. */
    public static final Point NO_POINT = new Point(-50, -50);
    
    /**
     * The start point of the tool.
     */
    private Point2D myStart;
    
    /**
     * The end point of the tool.
     */
    private Point2D myEnd;
    
    /**
     * the shape object that defines which tool being used.
     */
    private Shape myShape;
    
    /**
     * The constructor to initialize the fields.
     */
    public AbstractPaintTool() {
        // initialize the fields
        this.myStart = NO_POINT;
        this.myEnd = NO_POINT;
        
    }
    
    /**
     * setter for the start point.
     */
    @Override
    public void setStartPoint(final Point2D thePoint) {
        myStart = (Point) thePoint.clone();
        myEnd = (Point) thePoint.clone();
    }
    
    /**
     * getter for the start point.
     */
    @Override
    public Point2D getStartPoint() {
        return myStart;
    }

    /**
     * setter for the end point.
     */
    @Override
    public void setEndPoint(final Point2D thePoint) {
        myEnd = (Point) thePoint.clone();
    }

    

    /**
     * getter for the end point.
     */
    @Override
    public Point2D getEndPoint() {
        return myEnd;
    }
    
    /**
     * sets the current tool being used.
     * 
     * @param theShape
     */
    protected void setShape(final Shape theShape) {
        this.myShape = theShape;
    }


    /**
     * getter for the shape.
     */
    @Override
    public Shape getShape() {
        return myShape;
    }
    
    
}

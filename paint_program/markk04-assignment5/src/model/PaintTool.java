/**
 * TCSS 305 assignment 5
 */
package model;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * This is an interface for the tools.
 * 
 * @author Mark Kulibaba
 * @version 4.0
 */
public interface PaintTool {

    /**
     * getter for the shape object.
     * 
     * @return the tool currently represented
     */
    Shape getShape();
    
    /*
     * setter for the start point.
     */
    void setStartPoint(Point2D theStart);
    
    /**
     * setter for the end point.
     * 
     * @param endPoint
     */
    void setEndPoint(Point2D theEnd);
    
    /**
     * getter for the start point.
     * 
     * @return
     */
    Point2D getStartPoint(); 
    
    /**
     * getter for the end point.
     * 
     * @return
     */
    Point2D getEndPoint(); 
    
   
}

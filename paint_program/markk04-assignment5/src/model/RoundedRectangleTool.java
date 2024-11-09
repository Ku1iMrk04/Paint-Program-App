/**
 * TCSS 305 assignment 5
 */
package model;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 * The sub class for the abstract class AbstractPaint.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class RoundedRectangleTool extends AbstractPaintTool  {
    
    /**
     * create the rounded rectangle.
     */
    @Override
    public Shape getShape() {
        
        final Point2D startPoint = getStartPoint();
        final Point2D endPoint = getEndPoint();
        final double x = Math.min(startPoint.getX(), endPoint.getX());
        final double y = Math.min(startPoint.getY(), endPoint.getY());
        final double width = Math.abs(startPoint.getX() - endPoint.getX());
        final double height = Math.abs(startPoint.getY() - endPoint.getY());
        final double arcWidth = 50;
        final double arcHeight = 50;
       
        return new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);
        
    }
    
    

}

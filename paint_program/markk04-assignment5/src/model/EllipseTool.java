/**
 * TCSS 305 assignment 5
 */
package model;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


/**
 * The sub class for the abstract class AbstractPaint.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class EllipseTool extends AbstractPaintTool {

    /**
     * create the ellipse.
     */
    @Override
    public Shape getShape() {
        final Point2D startPoint = getStartPoint();
        final Point2D endPoint = getEndPoint();
        final double x = Math.min(startPoint.getX(), endPoint.getX());
        final double y = Math.min(startPoint.getY(), endPoint.getY());
        final double width = Math.abs(startPoint.getX() - endPoint.getX());
        final double height = Math.abs(startPoint.getY() - endPoint.getY());
        
        return new Ellipse2D.Double(x, y, width, height);
        
    }
    

}

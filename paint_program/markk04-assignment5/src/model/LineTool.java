/**
 * TCSS 305 assignment 5
 */
package model;


import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


/**
 * The sub class Line that extends the abstract paint and responsible for the line
 * shape.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class LineTool extends AbstractPaintTool {

    /**
     * create the line.
     */
    @Override
    public Shape getShape() {

        final Point2D startPoint = getStartPoint();
        final Point2D endPoint = getEndPoint();
        
        return new Line2D.Double(startPoint, endPoint);
    }
    

}

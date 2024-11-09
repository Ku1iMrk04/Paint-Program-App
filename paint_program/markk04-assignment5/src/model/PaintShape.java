/**
 * TCSS 305 assignment 5
 */
package model;

import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;


/**
 * Shape class that contains all the attributes of a shape.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class PaintShape {
    /**
     * instance of the current shape.
     */
    private final Shape myShape;
    /**
     * instance of the current color.
     */
    private Color myColor;
    /**
     * instance of the current stroke(thickness).
     */
    private Stroke myStroke;
    

    /**
     * Constructs a PaintShape object with the specified shape, color, and thickness.
     * 
     * @param shape the shape drawn
     * @param color the color of the shape
     * @param stroke the stroke used to draw the shape
     */
    public PaintShape(final Shape theShape, 
                      final Color theColor, 
                      final Stroke theStroke) {
        
        myShape = theShape;
        myColor = theColor;
        myStroke = theStroke;
    }

    /**
     * Gets the shape of the PaintShape.
     * 
     * @return the shape
     */
    public Shape getShape() {
        return myShape;
    }

    /**
     * Gets the color of the PaintShape.
     * 
     * @return the color
     */
    public Color getColor() {
        return myColor;
    }

    /**
     * Gets the stroke of the PaintShape.
     * 
     * @return the stroke
     */
    public Stroke getStroke() {
        return myStroke;
    }
   
    /**
     * Sets the color of the PaintShape.
     * 
     * @param color the color to set
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }

    /**
     * Sets the stroke of the PaintShape.
     * 
     * @param stroke the stroke to set
     */
    public void setStroke(final Stroke theStroke) {
        myStroke = theStroke;
    }


}
